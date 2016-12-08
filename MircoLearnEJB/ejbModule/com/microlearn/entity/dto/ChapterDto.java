package com.microlearn.entity.dto;



import com.microlearn.entity.Module;
import com.microlearn.entity.MultipleChoiceTest;

public class ChapterDto {

	private int id;	
	private Module module;
	private MultipleChoiceTestDto mct;
	private String title;
	private String content;
	private int position;
	
	public ChapterDto(int id, Module module, String title, String content, int position, MultipleChoiceTest mct) {
		super();
		this.id = id;
		this.module = module;
		this.title = title;
		this.content = content;
		this.position = position;
		if(mct != null)
			this.mct = new MultipleChoiceTestDto(mct.getId(), mct.getQuestions(), mct.getAttempts(), mct.getSuccessCondition());
		else
			this.mct = null;
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
	
	public MultipleChoiceTestDto getMct() {
		return mct;
	}
}
