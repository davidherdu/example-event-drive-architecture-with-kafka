package com.davidherdu.microservices.teacherexams.application.forms;

public class ExamForm {

	private int id;
	private int mark;

	public ExamForm() {
		super();
	}

	public ExamForm(int id, int mark) {
		super();
		this.id = id;
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
}
