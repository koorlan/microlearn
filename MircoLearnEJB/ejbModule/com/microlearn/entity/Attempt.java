package com.microlearn.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Attempt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private MultipleChoiceTest mct;
	
	@ManyToOne
	private Student student;	
	private Date date;	
	private boolean success;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MultipleChoiceTest getMct() {
		return mct;
	}
	public void setMct(MultipleChoiceTest mct) {
		this.mct = mct;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
}
