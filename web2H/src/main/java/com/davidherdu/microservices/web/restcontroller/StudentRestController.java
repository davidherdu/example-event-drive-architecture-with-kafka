package com.davidherdu.microservices.web.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidherdu.microservices.web.dto.ExamDto;
import com.davidherdu.microservices.web.dto.StudentDto;
import com.davidherdu.microservices.web.mappers.ExamMapper;
import com.davidherdu.microservices.web.mappers.StudentMapper;
import com.davidherdu.microservices.web.models.Exam;
import com.davidherdu.microservices.web.models.Student;
import com.davidherdu.microservices.web.services.StudentExamService;

@RestController
@RequestMapping("webapi/students")
public class StudentRestController {
	
	private StudentExamService studentExamService;

	public StudentRestController(StudentExamService studentExamService) {
		super();
		this.studentExamService = studentExamService;
	}

	@GetMapping
	public List<StudentDto> findAll() {
		return studentExamService.findAllStudents().stream().map(StudentMapper::toDto).toList();
	}

	@PostMapping
	public void insert(@RequestBody StudentDto studentDto) {
		studentExamService.insert(StudentMapper.toBo(studentDto));
	}

	@GetMapping("/{name}/exams")
	public List<Exam> findAllExams(@PathVariable("name") String name) {
		Student student = new Student(name);
		return studentExamService.findAllExams(student);
	}
	
	@PostMapping("/{name}/exams")
	public void insertExam(@PathVariable("name") String name, @RequestBody ExamDto examDto) {
		Student student = studentExamService.findOneStudent(name);
		
		Exam exam = ExamMapper.toBo(examDto);
		exam.setStudent(student);
		
		studentExamService.insert(exam);
	}
}
