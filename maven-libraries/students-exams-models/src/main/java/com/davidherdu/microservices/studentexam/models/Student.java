package com.davidherdu.microservices.studentexam.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {

	@Id
	private String name;
	private int age;
	@JsonIgnore
	@OneToMany(mappedBy = "student")
	private List<Exam> exams = new ArrayList<>();

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public Student() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	
	public void addExam(Exam exam) {
		this.exams.add(exam);
		exam.setStudent(this);
	}
	
	public void removeExam(Exam exam) {
		this.exams.remove(exam);
		exam.setStudent(null);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name);
	}
}
