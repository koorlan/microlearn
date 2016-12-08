package com.microlearn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class MultipleChoiceTest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="mct", cascade=CascadeType.REMOVE)
	private List<Question> questions;
	
	@OneToMany(mappedBy="mct", cascade=CascadeType.REMOVE)
	private List<Attempt> attempts;
	
	private int successCondition;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Attempt> getAttempts() {
		return attempts;
	}

	public void setAttempts(List<Attempt> attempts) {
		this.attempts = attempts;
	}

	public int getSuccessCondition() {
		return successCondition;
	}

	public void setSuccessCondition(int successCondition) {
		this.successCondition = successCondition;
	}
	
}
