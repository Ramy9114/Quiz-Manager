package fr.epita.quiz.services.business;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.dao.MCQChoiceDAO;
import fr.epita.quiz.services.dao.QuestionDAO;

public class QuizCreatorDataService {
	
	@Inject
	QuestionDAO questionDAO;
	
	@Inject
	MCQChoiceDAO mcqChoiceDAO;
	
	@Transactional(value = TxType.REQUIRED)
	public void createQuestionAndChoices(Question question, List<MCQChoice> mcqChoices) 
			throws ExamBusinessException{
		
		if(question != null && mcqChoices != null) {
			questionDAO.create(question);
		
		for(MCQChoice curr  : mcqChoices) {
			mcqChoiceDAO.create(curr);
		}

		}else {
			System.out.println("values are null");
		}
		
	}
	

}
