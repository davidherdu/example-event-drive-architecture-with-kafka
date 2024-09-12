package com.davidherdu.microservices.distributed.dtos;

public class ExamDto {

	private int id;
	private String text;
	private String subject;
	private double mark;

	public ExamDto() {
		super();
	}

	public ExamDto(int id, String text, String subject, double mark) {
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
}
