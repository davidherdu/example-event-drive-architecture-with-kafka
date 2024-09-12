package com.davidherdu.microservices.studentexam.mappers;

import com.davidherdu.microservices.studentexam.dto.StudentDto;
import com.davidherdu.microservices.studentexam.models.Student;

public class StudentMapper {

	public static Student toBo(StudentDto studentDto) {
		return new Student(studentDto.getName(), studentDto.getAge());
	}
	
	public static StudentDto toDto(Student student) {
		return new StudentDto(student.getName(), student.getAge());
	}
}
