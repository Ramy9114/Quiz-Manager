package fr.epita.quiz.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.dto.AnswerDTO;
import fr.epita.quiz.dto.ExamDTO;
import fr.epita.quiz.services.business.ExamBusinessException;
import fr.epita.quiz.services.business.ExamDataService;
import fr.epita.quiz.services.dao.AnswerDAO;
import fr.epita.quiz.services.dao.ExamDAO;
import fr.epita.quiz.services.dao.QuestionDAO;


@Path("/exam")
public class ExamResource {

	@Inject
	ExamDataService examDS;
	
	@Inject
	AnswerDAO answerDAO;
	
	@Inject
	ExamDAO examDAO;
	
	@Inject
	QuestionDAO questionDAO;
	
	
	@POST
	@Path("/create-exam")
	@Consumes(value=MediaType.APPLICATION_JSON)
	public Response createExam(@RequestBody ExamDTO examDTO) throws ExamBusinessException {
		System.out.println("i am creating a new exam");
		
		Exam exam = new Exam();
		exam.setTitle(examDTO.getTitle());
		
		examDS.createExam(exam);
		try {
			return Response.created(new URI("/rest/exam/create-exam" 
																	+ exam.getId())).entity(exam).build();
		} catch (URISyntaxException e) {
			// TODO Handle things properly
			e.printStackTrace();
		}
		
		return Response.serverError().build();
	}
	
	@GET
	@Path("/get-exam/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getExam(@PathParam("id") long examId) {
		System.out.println("i am getting the exam from the ID");
		
		Exam exam = examDAO.getById(examId);
		
		
		return Response.ok(exam).build();
	}

	@POST
	@Path("/answer")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response addAnswerToQuestion(@RequestBody AnswerDTO answerDTO) throws ExamBusinessException { 
		
		Answer answer = new Answer();
		answer.setContent(answerDTO.getContent());
		answer.setIsCorrect(answerDTO.getIsCorrect());
		
		Question question = questionDAO.getById(answerDTO.getQuestionId());
		
		Exam exam = examDAO.getById(answerDTO.getExamId());
		
		
		System.out.println("got post with:" +answerDTO.getContent());
		
		examDS.answerToQuestion(question, answer, exam);
		
		try {
			return Response.created(new URI("/rest/creator/question-and-choices" 
																	+ answer.getId())).build();
		} catch (URISyntaxException e) {
			// TODO Handle things properly
			e.printStackTrace();
		}
		
		
		return Response.serverError().build();
	}
	
	@GET
	@Path("/answer/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAnswer(@PathParam("id") long answerId) {
		System.out.print("Du ma may");
		//beginning dummy implementation
		Answer answer = answerDAO.getById(answerId);
		return Response.ok(answer).build();
	}
	
	@GET
	@Path("/get-all-answers")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAllAnswers() {
		
		Answer answer = new Answer();
		
		Exam exam = examDAO.getById(1l);
		answer.setExam(exam);
		
		List<Answer> answers = answerDAO.search(answer);
		
		
		return Response.ok(answers).build();
	}
	
	
	@GET
	@Path("/get-exam-result")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getExamResult() {
		
		int result = 0;
		
		Answer answer = new Answer();
		
		Exam exam = examDAO.getById(1l);
		answer.setExam(exam);
		
		List<Answer> answers = answerDAO.search(answer);
		
		for(Answer curr : answers) {
			if(curr.getIsCorrect() == true) {
				result += 1;
			}
		}
		
		return Response.ok(result).build();
	}
//	
//	
//	@GET
//	@Path("/answer")
//	@Produces(value = MediaType.APPLICATION_JSON)
//	public Response getAnswers() {
//		System.out.print("Du ma may");
//		//beginning dummy implementation
//		Answer answer = new Answer();
//		answer.setContent("This is a sampleAnswer");
//		
//		AnswerDTO answerDTO = new AnswerDTO(answer);
//		
//		return Response.ok(Arrays.asList(answerDTO)).build();
//	}
//	
//	
//	//@PUT
//	
//	//@DELETE
//	
//	@DELETE
//	@Path("/answer")
//	@Consumes(value = MediaType.APPLICATION_JSON)
//	//replace void by Response
//	public Response removeAnswer(@RequestBody AnswerDTO answerDTO) { //@RequestBody AnswerDTO answerDTO AS PARAMETER
//		System.out.print("Du ma may");
//
//		Answer answer = new Answer();
//		answer.setContent(answerDTO.getContent());
//		answer.setId(1l/*get the id from the dto*/);
//		//dao.delete(answer);
//		
//		
//		//TODO call examDS on this answer
//		try {
//			return Response.created(new URI("/rest/exam/answer/" + answer.getId())).build();
//		} catch (URISyntaxException e) {
//			// TODO Handle things properly
//			e.printStackTrace();
//		}
//		return Response.serverError().build();
//	
//	}

}

