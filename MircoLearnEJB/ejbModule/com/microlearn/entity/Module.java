package com.microlearn.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Module {

	@Id
	private long id;
	
	@OneToMany(mappedBy="module")
	private List<Chapter> chapters;
	
	@ManyToOne
	private Teacher teacher;
	
	private String title;
	private String content;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Chapter> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	
}
