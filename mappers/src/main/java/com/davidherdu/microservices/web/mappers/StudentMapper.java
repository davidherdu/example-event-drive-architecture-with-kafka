package com.davidherdu.microservices.web.mappers;

import com.davidherdu.microservices.web.dto.StudentDto;
import com.davidherdu.microservices.web.models.Student;

public class StudentMapper {

	public static Student toBo(StudentDto studentDto) {
		return new Student(studentDto.getName(), studentDto.getAge());
	}
	
	public static StudentDto toDto(Student student) {
		return new StudentDto(student.getName(), student.getAge());
	}
}
