package com.davidherdu.microservices.web3.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.davidherdu.microservices.web3.dtos.ExamDto;
import com.davidherdu.microservices.web3.mappers.ExamMapper;
import com.davidherdu.microservices.web3.services.ExamService;

@Component
public class ExamListener {

	private ExamService examService;
	
	public ExamListener(ExamService examService) {
		super();
		this.examService = examService;
	}

	@KafkaListener(topics = "exam-events", groupId = "group1", containerFactory = "examListenerFactory")
	public void insert(ExamDto examDto) {
		System.out.println("estoy en el listener");
		examService.insert(ExamMapper.toBo(examDto));
	}
}
