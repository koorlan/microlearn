package com.microlearn.entity.dto;

import java.util.List;


import com.microlearn.entity.Chapter;

public class ModuleDto {
	
	private long id;
	private List<Chapter> chapters;	
	private String title;
	private String content;
	
	public ModuleDto(long id, List<Chapter> chapters, String title, String content) {
		super();
		this.id = id;
		this.chapters = chapters;
		this.title = title;
		this.content = content;
	}
	
	public long getId() {
		return id;
	}
	public List<Chapter> getChapters() {
		return chapters;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	
	
	
}
