package com.davidherdu.microservices.web.mappers;

import com.davidherdu.microservices.web.dto.ExamDto;
import com.davidherdu.microservices.web.models.Exam;

public class ExamMapper {

	public static Exam toBo(ExamDto examDto) {
		Exam e = new Exam();
		e.setId(examDto.getId());
		e.setSubject(examDto.getSubject());
		e.setText(examDto.getText());
		e.setMark(examDto.getMark());
		return e;
	}
	
	public static ExamDto toDto(Exam exam) {
		ExamDto dto = new ExamDto();
		dto.setId(exam.getId());
		dto.setSubject(exam.getSubject());
		dto.setText(exam.getText());
		dto.setMark(exam.getMark());
		return dto;
	}
}
