package fr.epita.quiz.dto;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.Question;

public class AnswerDTO {
	
	private String content;
	
	private Long questionId;
	
	private Long examId;
	
	private boolean isCorrect;
	
	public AnswerDTO() {
		
	}
	
	public AnswerDTO(Answer entity) {
		this.content = entity.getContent();
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestion(Long question) {
		this.questionId = questionId;
	}

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}

