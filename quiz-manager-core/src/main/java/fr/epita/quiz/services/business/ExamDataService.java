package fr.epita.quiz.services.business;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.User;
import fr.epita.quiz.services.dao.AnswerDAO;
import fr.epita.quiz.services.dao.ExamDAO;
import fr.epita.quiz.services.dao.QuestionDAO;
import fr.epita.quiz.services.dao.UserDAO;



public class ExamDataService {
	
	@Inject
	UserDAO userDAO;
	
	@Inject
	QuestionDAO questionDAO;
	
	@Inject
	AnswerDAO answerDAO;
	
	@Inject
	ExamDAO examDAO;
	
	@Transactional(value = TxType.REQUIRED)
	public void createExam(Exam exam) throws ExamBusinessException {
		if(exam != null) {
			examDAO.create(exam);
		}
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void answerToQuestion(Question question, Answer answer, Exam exam) throws ExamBusinessException {
		//check values
		//if not valid : throw exception?
		
		//main logic part
		//checks if the question exists in db, same for user
		//	first : check if there's an id
		//  call dao.getById(obj) to check if it there
		
		//otherwise : throw exception?
		
		//Adding user and questions to the answer
		
		if(answer!= null && question != null) {
			answer.setQuestion(question); 
			answer.setExam(exam);
			
			answerDAO.create(answer);
		}
		
		
		
		
		
	}
	
	//public answerToMCQ(User user, MCQQuestion mcq, List<MCQChoices> choices);
	

}
