package com.microlearn.entity.dto;

import java.util.ArrayList;
import java.util.List;

import com.microlearn.entity.Answer;

public class QuestionDto {

	private int id;
	private String questionText;
	private List<AnswerDto> answers;
	
	public QuestionDto(int id, String questionText, List<Answer> answers) {
		this.id = id;
		this.questionText = questionText;
		this.answers = new ArrayList<AnswerDto>();
		for(Answer answer : answers) {
			this.answers.add(new AnswerDto(answer.getId(), answer.getText(), answer.isTrue()));
		}
	}

	public int getId() {
		return id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public List<AnswerDto> getAnswers() {
		return answers;
	}
}
