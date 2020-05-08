package fr.epita.quiz.tests.integration;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.business.ExamBusinessException;
import fr.epita.quiz.services.business.QuizCreatorDataService;
import fr.epita.quiz.services.dao.MCQChoiceDAO;
import fr.epita.quiz.services.dao.QuestionDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestQuizCreatorDataService {
	@Inject
	QuizCreatorDataService quizCreatorDS;
	
	@Inject
	QuestionDAO questionDAO;
	
	@Inject
	MCQChoiceDAO mcqChoiceDAO;
	
	@Test
	public void testCreateQuestion() {
		//given
		Question question = new Question();
		question.setTitle("Who's the first president of USA?");
		
		
		//when
		//try to execute the createQuestion function from QuizCreatorDataService
//		try {
//			quizCreatorDS.createQuestionAndChoices(question);
//		} catch (ExamBusinessException e) {
//			//Log exception using a logger
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//then
		
//		MCQChoice fetchedChoice = mcqChoiceDAO.getById(mcqChoice.getId());
//		assertEquals(fetchedChoice.getQuestion().getTitle(), question.getTitle());
		
		Question fetchedQuestion = questionDAO.getById(question.getId());
		assertEquals(fetchedQuestion.getTitle(), question.getTitle());
		
		
		
	}
}








