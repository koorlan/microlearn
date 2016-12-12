package com.microlearn.entity.dto;

import java.util.Date;

public class AttemptDto {

	private int id;
	private Date date;	
	private int score;
	private String userLogin;

	public AttemptDto(int id, Date date, int score, String userLogin) {
		this.id = id;
		this.date = date;
		this.score = score;
		this.userLogin = userLogin;
	}

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public int getScore() {
		return score;
	}

	public String getUserLogin() {
		return userLogin;
	}
}
