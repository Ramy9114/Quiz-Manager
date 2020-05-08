package fr.epita.quiz.datamodel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="QUESTIONS")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="Q_TITLE")
	private String title;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "MCQQUESTIONS_QUESTIONS")
	List<MCQChoice> mcqChoices;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ANSWERS_QUESTIONS")
	List<Answer> answers;
	
	@ManyToOne
	@JoinColumn(name = "Q_EXAM_FK")
	private Exam exam;
	
	public Question() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

//	public List<MCQChoice> getMcqChoices() {
//		return mcqChoices;
//	}
//
//	public void setMcqChoices(List<MCQChoice> mcqChoices) {
//		this.mcqChoices = mcqChoices;
//	}

	
}
