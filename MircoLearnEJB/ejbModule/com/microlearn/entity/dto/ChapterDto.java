package com.microlearn.entity.dto;



import com.microlearn.entity.Module;

public class ChapterDto {

	private int id;	
	private Module module;	
	private String title;
	private String content;
	private int position;
	
	public ChapterDto(int id, Module module, String title, String content, int position) {
		super();
		this.id = id;
		this.module = module;
		this.title = title;
		this.content = content;
		this.position = position;
	}

	public int getId() {
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

	public int compareTo(ChapterDto a) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    if(this.position == a.position)
	    	return EQUAL;
	    if(this.position > a.position)
	    	return BEFORE;
	    if(this.position < a.position)
	    	return AFTER;    
		return AFTER;    
	}
	
}
