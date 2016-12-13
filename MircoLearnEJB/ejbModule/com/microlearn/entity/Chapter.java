package com.microlearn.entity;

import javax.persistence.*;


@Entity
public class Chapter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Module module;
	
	@OneToOne(mappedBy="chapter")
	private MultipleChoiceTest mct;
	
	private String title;
	@Column(columnDefinition="text")
	private String content;
	private int position;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
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
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public MultipleChoiceTest getMct() {
		return mct;
	}
	public void setMct(MultipleChoiceTest mct) {
		this.mct = mct;
	}
}
