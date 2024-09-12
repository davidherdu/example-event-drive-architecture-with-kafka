package com.davidherdu.microservices.studentsexams.frontend.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.davidherdu.microservices.studentsexams.frontend.forms.ExamForm;
import com.davidherdu.microservices.web.dto.ExamDto;
import com.davidherdu.microservices.web.dto.StudentDto;

@Controller
public class StudentController {
	
	@Value("${web2.server}")
	String server;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	StudentClient studentClient;

	@RequestMapping("/studentslist")
	public String studentsList(Model model) {
		StudentDto[] list = studentClient.getStudents();
				// restTemplate.getForEntity(server + "/students", StudentDto[].class).getBody();
		model.addAttribute("studentslist", Arrays.asList(list));
		return "studentslist.xhtml";
	}
	
	@RequestMapping("/examslist")
	public String examsList(Model model, @RequestParam("name") String name) {
		ExamDto[] list = studentClient.studentExams(name); 
				// restTemplate.getForEntity(server + "/students/" + name + "/exams", ExamDto[].class).getBody();
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
		//restTemplate.postForEntity(server + "/students", student, StudentDto.class);
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
		
		// restTemplate.postForEntity(server + "/students/" + examForm.getName() + "/exams", dto, ExamDto.class);
		studentClient.insertExam(examForm.getName(), dto);
		
		ExamDto[] list = studentClient.studentExams(examForm.getName());
				// restTemplate.getForEntity(server + "/students/" + examForm.getName() + "/exams", ExamDto[].class).getBody();
		model.addAttribute("examslist", Arrays.asList(list));
		model.addAttribute("name", examForm.getName());
		
		return "examslist.xhtml";
	}
}
