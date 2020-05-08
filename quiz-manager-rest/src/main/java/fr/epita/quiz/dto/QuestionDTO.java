package fr.epita.quiz.dto;

import java.util.List;

import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;

public class QuestionDTO {

	private String title;

	private List<MCQChoice> mcqChoices;

//	private Exam exam;
	private String examID;

	public QuestionDTO() {

	}

	public QuestionDTO(Question entity) {
		this.title = entity.getTitle();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<MCQChoice> getMcqChoices() {
		return mcqChoices;
	}

	public void setMcqChoices(List<MCQChoice> mcqChoices) {
		this.mcqChoices = mcqChoices;
	}

//	public Exam getExam() {
//		return exam;
//	}
//
//	public void setExam(Exam exam) {
//		this.exam = exam;
//	}

	public String getExamID() {
		return examID;
	}

	public void setExamID(String examId) {
		this.examID = examID;
	}

}
