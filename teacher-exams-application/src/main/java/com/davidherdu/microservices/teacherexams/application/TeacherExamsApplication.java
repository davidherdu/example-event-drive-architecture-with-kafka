package com.davidherdu.microservices.teacherexams.application;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.davidherdu.microservices.distributed.dtos.ExamDto;

@SpringBootApplication
@EntityScan(basePackages = "com.davidherdu.microservices.distributed.models")
public class TeacherExamsApplication {

	@Value("${kafka.bootstrap-servers}") 
	private String bootstrapServers;

	public static void main(String[] args) {
		SpringApplication.run(TeacherExamsApplication.class, args);
	}
	
	@Bean
    public ConsumerFactory<String, ExamDto> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        
        JsonDeserializer<ExamDto> deserializer = new JsonDeserializer<ExamDto>(ExamDto.class);
        deserializer.addTrustedPackages("com.davidherdu.microservices.distributed.dtos");
        
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
    }

    @Bean(name="examListenerFactory")
    public ConcurrentKafkaListenerContainerFactory<String, ExamDto> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ExamDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
