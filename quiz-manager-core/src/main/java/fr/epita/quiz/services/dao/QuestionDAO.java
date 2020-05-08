package fr.epita.quiz.services.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;


public class QuestionDAO extends GenericDAO<Question, Long>{
	@PersistenceContext
	private EntityManager em;


	@Override
	public String getQuery() {
		return "from Question where exam = :pExam";

	}
	@Override
	public void setParameters(Map<String, Object> parameters, Question criteria) {
		parameters.put("pExam", criteria.getExam());
		
	}


	@Override
	public Class<Question> getEntityClass() {
		return Question.class;
	}
	
//	public List<MCQChoice> getListOfChoices(Question criteria){
//		Query searchQuery = em.createQuery(getQueryForChoices());
//		Map<String, Object> parameters = new LinkedHashMap<String, Object>();
//		setParameters(parameters, criteria);
//		for(Map.Entry<String, Object> entry : parameters.entrySet()) {
//			searchQuery.setParameter(entry.getKey(), entry.getValue());
//		}
//		
//		return searchQuery.getResultList();
//	}
//	
//	public String getQueryForChoices() {
//		return "from MCQChoice where question = :pQuestion";
//	}
	


	

}
