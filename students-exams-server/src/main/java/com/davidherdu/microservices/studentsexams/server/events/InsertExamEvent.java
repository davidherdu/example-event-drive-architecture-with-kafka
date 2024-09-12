package com.davidherdu.microservices.studentsexams.server.events;

import org.springframework.context.ApplicationEvent;

import com.davidherdu.microservices.distributed.dtos.ExamDto;

public class InsertExamEvent extends ApplicationEvent {

	public InsertExamEvent(ExamDto examDto) {
		super(examDto);
	}

}
