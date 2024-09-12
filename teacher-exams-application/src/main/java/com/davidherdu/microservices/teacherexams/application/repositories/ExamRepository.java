package com.davidherdu.microservices.teacherexams.application.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.davidherdu.microservices.web3.models.Exam;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ExamRepository {

	@PersistenceContext
	private EntityManager em;
	
	public List<Exam> findAll() {
		TypedQuery<Exam> query = em.createQuery("select e from Exam e", Exam.class);
		return query.getResultList();
	}
	
	public Exam findOne(int id) {
		return em.find(Exam.class, id);
	}
	
	@Transactional
	public void insert(Exam exam) {
		em.persist(exam);
	}
	
	@Transactional
	public void update(Exam exam) {
		em.merge(exam);
	}
}
