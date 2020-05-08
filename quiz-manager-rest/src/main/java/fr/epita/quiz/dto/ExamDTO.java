package fr.epita.quiz.dto;

import java.util.List;

import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;

public class ExamDTO {

	private String title;
	
	private List<Question> questions;
	
	public ExamDTO() {
		
	}
	
	public ExamDTO(Exam entity) {
		this.title = entity.getTitle();
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Question> getQuestion() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
