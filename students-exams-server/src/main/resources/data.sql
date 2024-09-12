DELETE FROM Student;
INSERT INTO Student (name, age) VALUES ('Juan', 25);
INSERT INTO Student (name, age) VALUES ('Maria', 30);
INSERT INTO Student (name, age) VALUES ('Carlos', 22);

DELETE FROM Exam;
INSERT INTO Exam (text, subject, mark, student_name) VALUES ('Question 1', 'Physics', 6, 'Juan');
