DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam (
	id INT auto_increment NOT NULL PRIMARY KEY,
	text VARCHAR(255),
	subject VARCHAR(255),
	mark number
);
