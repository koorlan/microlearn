package com.microlearn.entity.dto;

import java.util.Date;

public class AttemptDto {

	private int id;
	private Date date;	
	private boolean success;
	private String userLogin;

	public AttemptDto(int id, Date date, boolean success, String userLogin) {
		this.id = id;
		this.date = date;
		this.success = success;
		this.userLogin = userLogin;
	}

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getUserLogin() {
		return userLogin;
	}
}
