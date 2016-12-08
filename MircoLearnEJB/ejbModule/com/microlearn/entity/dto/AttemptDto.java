package com.microlearn.entity.dto;

import java.util.Date;

public class AttemptDto {

	private int id;
	private Date date;	
	private boolean success;

	public AttemptDto(int id, Date date, boolean success) {
		this.id = id;
		this.date = date;
		this.success = success;
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
}
