package com.microlearn.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="module", fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)
	private List<Chapter> chapters;
	
	@ManyToOne
	private Teacher teacher;
	
	@ManyToMany(mappedBy="followedModules")
	private List<Student> followers;
	
	private String title;
	private String content;

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public List<Student> getFollowers() {
		return followers;
	}
	public void setFollowers(List<Student> followers) {
		this.followers = followers;
	}	
}
