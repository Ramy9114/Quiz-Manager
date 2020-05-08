package fr.epita.quiz.dto;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;

public class MCQChoiceDTO {

	private String content;
	
	private Question question;
	
	private boolean isCorrectAnswer;
	
	public MCQChoiceDTO() {
		
	}
	
	public MCQChoiceDTO(MCQChoice entity) {
		this.content = entity.getChoice();
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}


	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public boolean getCorrectAnswer() {
		return isCorrectAnswer;
	}

	public void setCorrectAnswer(boolean isCorrectAnswer) {
		this.isCorrectAnswer = isCorrectAnswer;
	}
}

