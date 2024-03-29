package com.microlearn.entity.dto;

import java.util.ArrayList;
import java.util.List;

import com.microlearn.entity.Attempt;
import com.microlearn.entity.Question;

public class MultipleChoiceTestDto {
	
	private int id;
	private List<QuestionDto> questions;
	private List<AttemptDto> attempts;	
	private int successCondition;
	private boolean showAnswers;
	
	public MultipleChoiceTestDto(int id, List<Question> questions, List<Attempt> attempts, int successCondition, boolean showAnswers) {
		this.id = id;
		this.questions = new ArrayList<QuestionDto>();
		for(Question question : questions) {
			this.questions.add(new QuestionDto(question.getId(), question.getQuestionText(), question.getAnswers()));
		}
		this.attempts = new ArrayList<AttemptDto>();
		for(Attempt attempt : attempts) {
			this.attempts.add(new AttemptDto(attempt.getId(), attempt.getDate(), attempt.getScore(), 
					attempt.getStudent().getLogin()));
		}
		this.successCondition = successCondition;
		this.showAnswers = showAnswers;
	}

	public int getId() {
		return id;
	}

	public List<QuestionDto> getQuestions() {
		return questions;
	}

	public List<AttemptDto> getAttempts() {
		return attempts;
	}

	public int getSuccessCondition() {
		return successCondition;
	}

	public boolean getShowAnswers() {
		return showAnswers;
	}
}
