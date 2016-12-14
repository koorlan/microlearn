package com.microlearn.entity.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.microlearn.entity.Chapter;
import com.microlearn.entity.Teacher;

public class ModuleDto {
	
	private int id;
	private List<ChapterDto> chapters;	
	private String title;
	private String content;
	private Teacher teacher;
	
	public ModuleDto(int id, List<Chapter> chapters, String title, String content, Teacher teacher) {
		this.id = id;
		this.chapters = new ArrayList<ChapterDto>();
		for(Chapter c: chapters){
			this.chapters.add(new ChapterDto(c.getId(),c.getModule(),c.getTitle(),c.getContent(),c.getPosition(), c.getMct(), id));
		}
		this.title = title;
		this.content = content;
		this.teacher = teacher;
	}
	
	public int getId() {
		return id;
	}
	public List<ChapterDto> getChapters() {
		Comparator<ChapterDto> comp = (ChapterDto a, ChapterDto b) -> {
		    return b.compareTo(a);
		};
		Collections.sort(this.chapters, comp);
		return chapters;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}

	public Teacher getTeacher() {
		return teacher;
	}
	
	
	
}
