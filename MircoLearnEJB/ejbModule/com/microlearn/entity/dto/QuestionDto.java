package com.microlearn.entity.dto;

import java.util.List;

public class QuestionDto {

	private int id;
	private String questionText;
	private List<String> goodAnswers;
	private List<String> badAnswers;
	
	public QuestionDto(int id, String questionText, List<String> goodAnswers, List<String> badAnswers) {
		this.id = id;
		this.questionText = questionText;
		this.goodAnswers = goodAnswers;
		this.badAnswers = badAnswers;
	}

	public int getId() {
		return id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public List<String> getGoodAnswers() {
		return goodAnswers;
	}

	public List<String> getBadAnswers() {
		return badAnswers;
	}	
}
