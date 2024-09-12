package com.davidherdu.microservices.web3.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davidherdu.microservices.web3.models.Exam;
import com.davidherdu.microservices.web3.repositories.ExamRepository;

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
