package com.davidherdu.microservices.web.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidherdu.microservices.web.models.Exam;
import com.davidherdu.microservices.web.services.StudentExamService;

@RestController
@RequestMapping("webapi/exams")
public class ExamRestController {

	private StudentExamService studentExamService;

	public ExamRestController(StudentExamService studentExamService) {
		super();
		this.studentExamService = studentExamService;
	}

	@GetMapping
	public List<Exam> findAllExams() {
		return studentExamService.findAllExams();
	}
}
