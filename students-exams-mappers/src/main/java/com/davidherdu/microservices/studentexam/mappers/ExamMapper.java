package com.davidherdu.microservices.studentexam.mappers;

import com.davidherdu.microservices.studentexam.dto.ExamDto;
import com.davidherdu.microservices.studentexam.models.Exam;

public class ExamMapper {

	public static Exam toBo(ExamDto examDto) {
		return new Exam(examDto.getId(), examDto.getText(), examDto.getSubject(), examDto.getMark());
	}
	
	public static ExamDto toDto(Exam exam) {
		return new ExamDto(exam.getId(), exam.getText(), exam.getSubject(), exam.getMark());
	}
}
