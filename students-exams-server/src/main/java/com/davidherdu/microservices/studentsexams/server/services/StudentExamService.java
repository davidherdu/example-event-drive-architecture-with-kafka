package com.davidherdu.microservices.studentsexams.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.davidherdu.microservices.distributed.dtos.ExamDto;
import com.davidherdu.microservices.studentexam.models.Exam;
import com.davidherdu.microservices.studentexam.models.Student;
import com.davidherdu.microservices.studentsexams.server.events.InsertExamEvent;
import com.davidherdu.microservices.studentsexams.server.repositories.ExamRepository;
import com.davidherdu.microservices.studentsexams.server.repositories.StudentRepository;

@Service
public class StudentExamService {

	@Autowired
	private ApplicationEventPublisher publisherEvents;
	
	private StudentRepository studentRepository;
	private ExamRepository examRepository;

	public StudentExamService(StudentRepository studentRepository, ExamRepository examRepository) {
		super();
		this.studentRepository = studentRepository;
		this.examRepository = examRepository;
	}

	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}

	public void insert(Student student) {
		studentRepository.insert(student);
	}
	
	public List<Exam> findAllExams() {
		return examRepository.findAll();
	}

	public List<Exam> findAllExams(Student student) {
		return studentRepository.findAllExams(student);
	}

	public void insert(Exam exam) {
		examRepository.insert(exam);
		
		ExamDto other = new ExamDto();
		other.setId(exam.getId());
		other.setText(exam.getText());
		other.setSubject(exam.getSubject());
		
		publisherEvents.publishEvent(new InsertExamEvent(other));
	}

	public Student findOneStudent(String name) {
		return studentRepository.findOne(name);
	}
}
