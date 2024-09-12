package com.davidherdu.microservices.studentsexams.frontend.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.davidherdu.microservices.studentexam.dto.ExamDto;
import com.davidherdu.microservices.studentexam.dto.StudentDto;
import com.davidherdu.microservices.studentsexams.frontend.forms.ExamForm;

@Controller
public class StudentController {
		
	@Autowired
	StudentClient studentClient;

	@RequestMapping("/studentslist")
	public String studentsList(Model model) {
		StudentDto[] list = studentClient.getStudents();
		model.addAttribute("studentslist", Arrays.asList(list));
		return "studentslist.xhtml";
	}
	
	@RequestMapping("/examslist")
	public String examsList(Model model, @RequestParam("name") String name) {
		ExamDto[] list = studentClient.studentExams(name); 
		model.addAttribute("examslist", Arrays.asList(list));
		model.addAttribute("name", name);
		return "examslist.xhtml";
	}
	
	@RequestMapping("/studentform")
	public String studentForm() {
		return "studentform.xhtml";
	}
	
	@RequestMapping("/examform")
	public String examForm(Model model, @RequestParam String name) {
		model.addAttribute("name", name);
		return "examform.xhtml";
	}
	
	@RequestMapping("/insertstudent")
	public String insertStudent(Model model, @ModelAttribute StudentDto student) {
		studentClient.postStudent(student);
		
		StudentDto[] list = studentClient.getStudents();
		model.addAttribute("studentslist", Arrays.asList(list));
		
		return "studentslist.xhtml";
	}
	
	@RequestMapping("/insertexam")
	public String insertExam(Model model, @ModelAttribute ExamForm examForm) {
		ExamDto dto = new ExamDto();
		dto.setSubject(examForm.getSubject());
		dto.setText(examForm.getText());
		
		studentClient.insertExam(examForm.getName(), dto);
		
		ExamDto[] list = studentClient.studentExams(examForm.getName());
		model.addAttribute("examslist", Arrays.asList(list));
		model.addAttribute("name", examForm.getName());
		
		return "examslist.xhtml";
	}
}
