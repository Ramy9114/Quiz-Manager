package fr.epita.quiz.services.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;

public class MCQChoiceDAO  extends GenericDAO<MCQChoice, Long>{

	@Override
	public String getQuery() {
		return "from MCQChoice where question = :pQuestion";
	}
	
	@Override
	public void setParameters(Map<String,Object> parameters, MCQChoice criteria) {
		parameters.put("pQuestion", criteria.getQuestion());
		
	}

	@Override
	public Class<MCQChoice> getEntityClass() {
		return MCQChoice.class;
	}
	
	
}
