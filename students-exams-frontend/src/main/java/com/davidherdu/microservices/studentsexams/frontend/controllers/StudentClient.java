package com.davidherdu.microservices.studentsexams.frontend.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.davidherdu.microservices.web.dto.ExamDto;
import com.davidherdu.microservices.web.dto.StudentDto;

@FeignClient(name="web", path="/webapi/students")
public interface StudentClient {

	@GetMapping
	StudentDto[] getStudents();
	@PostMapping
	void postStudent(@RequestBody StudentDto student);
	
	@GetMapping("/{name}/exams")
	ExamDto[] studentExams(@PathVariable("name") String name);
	
	@PostMapping("/{name}/exams")
	StudentDto[] insertExam(@PathVariable("name") String name, @RequestBody ExamDto exam);
}
