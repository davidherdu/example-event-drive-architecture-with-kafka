package com.davidherdu.microservices.web3.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Exam {

	@Id
	private int id;
	private String text;
	private String subject;
	private double mark;
	
	public Exam() {
		super();
	}
	
	public Exam(int id) {
		super();
		this.id = id;
	}
	
	public Exam(int id, String text, String subject, double mark) {
		super();
		this.id = id;
		this.text = text;
		this.subject = subject;
		this.mark = mark;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public double getMark() {
		return mark;
	}
	
	public void setMark(double mark) {
		this.mark = mark;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exam other = (Exam) obj;
		return id == other.id;
	}
}
