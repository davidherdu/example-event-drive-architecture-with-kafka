package com.davidherdu.microservices.web.repositories;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.davidherdu.microservices.web.models.Exam;
import com.davidherdu.microservices.web.models.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Student findOne(String name) {
		return em.find(Student.class, name);
	}
	
	public List<Student> findAll() {
		TypedQuery<Student> query = em.createQuery("select st from Student st", Student.class);
		return query.getResultList();
	}
	
	public List<Exam> findAllExams(Student student) {
		TypedQuery<Exam> query = em.createQuery("select e from Exam e where e.student.name =:name", Exam.class);
		query.setParameter("name", student.getName());
		return query.getResultList();
	}
	
	@Transactional
	public void insert(Student student) {
		em.persist(student);
	}
}
