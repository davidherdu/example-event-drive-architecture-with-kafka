package com.davidherdu.microservices.web.events;

import org.springframework.context.ApplicationEvent;

import com.davidherdu.microservices.web3.dtos.ExamDto;

public class InsertExamEvent extends ApplicationEvent {

	public InsertExamEvent(ExamDto examDto) {
		super(examDto);
	}

}
