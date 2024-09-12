package com.davidherdu.microservices.web3.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.davidherdu.microservices.web3.forms.ExamForm;
import com.davidherdu.microservices.web3.models.Exam;
import com.davidherdu.microservices.web3.services.ExamService;

@Controller
public class ExamController {

	private ExamService examService;

	public ExamController(ExamService examService) {
		super();
		this.examService = examService;
	}

	@GetMapping("/examslist")
	public String findAll(Model model) {
		List<Exam> examsList = examService.findAll();
		model.addAttribute("examslist", examsList);
		return "examslist.xhtml";
	}
	
	@GetMapping("/examform")
	public String examForm(Model model, @RequestParam("id") int id) {
		Exam exam = examService.findOne(id);
		model.addAttribute("exam", exam);
		return "examform.xhtml";
	}

	@PostMapping("/updateexam")
	public String update(Model model, @ModelAttribute ExamForm form) {
		Exam exam = examService.findOne(form.getId());
		exam.setMark(form.getMark());
		examService.update(exam);
		
		List<Exam> examsList = examService.findAll();
		model.addAttribute("examslist", examsList);
		
		return "examslist.xhtml";
	}
}
