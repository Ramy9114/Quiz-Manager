package fr.epita.quiz.services.dao;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epita.quiz.datamodel.Exam;

public class ExamDAO extends GenericDAO<Exam, Long>{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public String getQuery() {
		return "from Exam where title = :pTitle";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, Exam criteria) {
		parameters.put("pTitle", criteria.getTitle());
		
	}

	@Override
	public Class<Exam> getEntityClass() {
		return Exam.class;
	}

}
