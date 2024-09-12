package com.davidherdu.microservices.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.davidherdu.microservices.web.events.InsertExamEvent;
import com.davidherdu.microservices.web.models.Exam;
import com.davidherdu.microservices.web.models.Student;
import com.davidherdu.microservices.web.repositories.ExamRepository;
import com.davidherdu.microservices.web.repositories.StudentRepository;
import com.davidherdu.microservices.web3.dtos.ExamDto;

@Service
public class StudentExamService {

	@Value("${web3.server}")
	String server;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private KafkaTemplate<String, ExamDto> kafkaTemplate;
	
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
		//restTemplate.postForEntity(server + "/exams", other, ExamDto.class);
		//kafkaTemplate.send("exam-events", other);
	}

	public Student findOneStudent(String name) {
		return studentRepository.findOne(name);
	}
}
