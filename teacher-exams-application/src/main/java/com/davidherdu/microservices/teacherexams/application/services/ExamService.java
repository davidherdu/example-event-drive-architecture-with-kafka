package com.davidherdu.microservices.teacherexams.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davidherdu.microservices.distributed.models.Exam;
import com.davidherdu.microservices.teacherexams.application.repositories.ExamRepository;

@Service
public class ExamService {

	private ExamRepository examRepository;

	public ExamService(ExamRepository examRepository) {
		super();
		this.examRepository = examRepository;
	}

	public List<Exam> findAll() {
		return examRepository.findAll();
	}

	public Exam findOne(int id) {
		return examRepository.findOne(id);
	}

	public void insert(Exam exam) {
		examRepository.insert(exam);
	}

	public void update(Exam exam) {
		examRepository.update(exam);
	}
}
