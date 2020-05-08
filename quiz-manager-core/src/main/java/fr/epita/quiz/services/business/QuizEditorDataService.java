package fr.epita.quiz.services.business;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import fr.epita.quiz.services.dao.MCQChoiceDAO;
import fr.epita.quiz.services.dao.QuestionDAO;

public class QuizEditorDataService {

	@Inject
	QuestionDAO questionDAO;
	
	@Inject
	MCQChoiceDAO mcqChoiceDAO;
	
	@Transactional(value = TxType.REQUIRED)
	public void getQuestionsAndChoices() 
			throws ExamBusinessException {
		
	}
}
