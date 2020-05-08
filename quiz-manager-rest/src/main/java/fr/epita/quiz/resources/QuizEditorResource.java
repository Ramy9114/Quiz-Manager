package fr.epita.quiz.resources;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.business.QuizEditorDataService;
import fr.epita.quiz.services.dao.ExamDAO;
import fr.epita.quiz.services.dao.MCQChoiceDAO;
import fr.epita.quiz.services.dao.QuestionDAO;

@Path("/editor")
public class QuizEditorResource {
	
	@Inject
	QuizEditorDataService quizEditorDS;
	
	@Inject
	QuestionDAO questionDAO;
	
	@Inject
	MCQChoiceDAO mcqChoiceDAO;
	
	@Inject
	ExamDAO	examDAO;
	
	@GET
	@Path("/get-all-questions/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getQuestions(@PathParam("id") long examId) {
		System.out.println("I am getting all Questions and Choices");
		System.out.println();
		
		Exam exam = examDAO.getById(examId);
		
		Question question = new Question();
		question.setTitle("Voila");
		question.setExam(exam);
		
		List<Question> questions = questionDAO.search(question);

		
		
//		for(Question curr : questions) {
//			MCQChoice mc = new MCQChoice();
//			mc.setChoice("haraamba");
//			mc.setQuestion(curr);
//			
//			List<MCQChoice> choices = mcqChoiceDAO.search(mc);
//			curr.setMcqChoices(choices);
//		}
		
		
		return Response.ok(questions).build();
	}
	
	@GET
	@Path("/get-choices/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getQuestion(@PathParam("id") long questionId) {
		System.out.println("i am getting the question from the ID");
		
		Question question = questionDAO.getById(questionId);
		
		MCQChoice mc = new MCQChoice();
		mc.setChoice("haraamba");
		mc.setQuestion(question);
		
		
		List<MCQChoice> choices = mcqChoiceDAO.search(mc);
//		List<Question> questions = questionDAO.search(question);
		
		
		return Response.ok(choices).build();
	}
}