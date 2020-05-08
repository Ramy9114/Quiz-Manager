package fr.epita.quiz.services.dao;

import java.util.Map;



import fr.epita.quiz.datamodel.Answer;

public class AnswerDAO extends GenericDAO<Answer, Long>{

	@Override
	public String getQuery() {
		return "from Answer where exam = :pExam";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, Answer criteria) {
		parameters.put("pExam", criteria.getExam());
	}

	@Override
	public Class<Answer> getEntityClass() {
		// TODO Auto-generated method stub
		return Answer.class;
	}



	

}
