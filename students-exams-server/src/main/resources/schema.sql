DROP TABLE IF EXISTS Student;
CREATE TABLE Student (
	name VARCHAR(255) NOT NULL PRIMARY KEY,
	age INT NOT NULL
);

DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam (
	id INT auto_increment NOT NULL PRIMARY KEY,
	text VARCHAR(255),
	subject VARCHAR(255),
	mark number,
	student_name VARCHAR(255)
);
