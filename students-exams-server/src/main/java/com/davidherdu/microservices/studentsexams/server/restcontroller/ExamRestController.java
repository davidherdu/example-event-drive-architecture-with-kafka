package com.davidherdu.microservices.studentsexams.server.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidherdu.microservices.studentsexams.server.services.StudentExamService;
import com.davidherdu.microservices.web.models.Exam;

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
