package com.microlearn.entity.dto;

public class AnswerDto {
	private int id;
	private String text;
	private boolean isTrue;
	
	public AnswerDto (int id, String text, boolean isTrue) {
		this.id = id;
		this.text = text;
		this.isTrue = isTrue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean getIsTrue() {
		return isTrue;
	}

	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}
}
