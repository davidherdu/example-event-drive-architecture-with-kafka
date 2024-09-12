package com.davidherdu.microservices.teacherexams.application.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidherdu.microservices.distributed.dtos.ExamDto;
import com.davidherdu.microservices.distributed.mappers.ExamMapper;
import com.davidherdu.microservices.distributed.models.Exam;
import com.davidherdu.microservices.teacherexams.application.services.ExamService;

@RestController
@RequestMapping("/webapi/exams")
public class ExamRestController {

	private ExamService examService;

	public ExamRestController(ExamService examService) {
		super();
		this.examService = examService;
	}

	public List<Exam> findAll() {
		return examService.findAll();
	}

	@PostMapping
	public void insert(@RequestBody ExamDto dto) {
		examService.insert(ExamMapper.toBo(dto));
	}

	public void update(Exam exam) {
		examService.update(exam);
	}
	
}
