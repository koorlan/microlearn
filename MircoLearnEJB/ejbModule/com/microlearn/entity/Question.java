package com.microlearn.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private MultipleChoiceTest mct;
	
	private String questionText;
	
	@ElementCollection
	private List<String> goodAnswers;
	
	@ElementCollection
	private List<String> badAnswers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<String> getGoodAnswers() {
		return goodAnswers;
	}

	public void setGoodAnswers(List<String> goodAnswers) {
		this.goodAnswers = goodAnswers;
	}

	public List<String> getBadAnswers() {
		return badAnswers;
	}

	public void setBadAnswers(List<String> badAnswers) {
		this.badAnswers = badAnswers;
	}
}
