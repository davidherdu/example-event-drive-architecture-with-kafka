package com.davidherdu.microservices.studentsexams.server.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.davidherdu.microservices.distributed.dtos.ExamDto;
import com.davidherdu.microservices.studentsexams.server.events.InsertExamEvent;

@Component
public class InsertExamListener implements ApplicationListener<InsertExamEvent> {

	@Autowired
	private KafkaTemplate<String, ExamDto> kafkaTemplate;
	
	@Override
	public void onApplicationEvent(InsertExamEvent event) {
		kafkaTemplate.send("exam-events", (ExamDto)event.getSource());
	}

}
