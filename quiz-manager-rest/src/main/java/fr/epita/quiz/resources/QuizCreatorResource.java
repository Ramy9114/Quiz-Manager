package fr.epita.quiz.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.dto.MCQChoiceDTO;
import fr.epita.quiz.dto.QuestionDTO;
import fr.epita.quiz.services.business.ExamBusinessException;
import fr.epita.quiz.services.business.QuizCreatorDataService;
import fr.epita.quiz.services.dao.ExamDAO;
import fr.epita.quiz.services.dao.MCQChoiceDAO;
import fr.epita.quiz.services.dao.QuestionDAO;

import fr.epita.quiz.resources.CorsFilter;

@Path("/creator")
public class QuizCreatorResource {

	
	@Inject
	QuizCreatorDataService quizCreatorDS;
	
	@Inject
	QuestionDAO questionDAO;
	
	@Inject
	MCQChoiceDAO  mcqChoiceDAO;
	
	@Inject
	ExamDAO examDAO;
	
	@POST
	@Path("/question-and-choices")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response createQuestion(@RequestBody QuestionDTO questionDTO) throws ExamBusinessException {
		
		
		
		System.out.println("VIETNAM NGUYEN !!!");
		
		
		Question question = new Question();
		question.setTitle(questionDTO.getTitle());
		
		Exam exam = examDAO.getById(1l);
		System.out.print(exam.getTitle());
//		exam.setTitle(questionDTO.getExam().getTitle());
		question.setExam(exam);
		
		
		
		List <MCQChoice> choices = new ArrayList<MCQChoice>();
		for(MCQChoice curr  : questionDTO.getMcqChoices()) {
			MCQChoice currChoice = new MCQChoice();
			currChoice.setQuestion(question);
			currChoice.setChoice(curr.getChoice());
			currChoice.setValid(curr.getValid());
			choices.add(currChoice);
			}
		
		
		
		System.out.println("got post with:" +questionDTO.getTitle());
		
		quizCreatorDS.createQuestionAndChoices(question, choices);
		
		try {
			return Response.created(new URI("/rest/creator/question-and-choices" 
																	+ question.getId())).build();
		} catch (URISyntaxException e) {
			// TODO Handle things properly
			e.printStackTrace();
		}
		
		
		return Response.serverError().build();

	}
	
	@GET
	@Path("/question/{id}")
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