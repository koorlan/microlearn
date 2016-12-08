package com.microlearn.entity.dto;



import com.microlearn.entity.Module;

public class ChapterDto {

	private long id;	
	private Module module;	
	private String title;
	private String content;
	private int position;
	
	public ChapterDto(long id, Module module, String title, String content, int position) {
		super();
		this.id = id;
		this.module = module;
		this.title = title;
		this.content = content;
		this.position = position;
	}

	public long getId() {
		return id;
	}

	public Module getModule() {
		return module;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
	
	public int getPosition() {
		return position;
	}
	
}
