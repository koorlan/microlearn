package com.microlearn.entity.dto;

import com.microlearn.entity.Attempt;
import com.microlearn.entity.Module;
import com.microlearn.entity.MultipleChoiceTest;

public class ChapterDto {

	private int id;
	private Module module;
	private MultipleChoiceTestDto mct;
	private boolean hasMCT;
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
		if(mct != null) {
			this.mct = new MultipleChoiceTestDto(mct.getId(), mct.getQuestions(), mct.getAttempts(), mct.getSuccessCondition());
			hasMCT = true;
		}
		else {
			this.mct = null;
			hasMCT = false;
		}
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
	
	public MultipleChoiceTestDto getMct() {
		return mct;
	}

	public boolean getHasMCT() {
		return hasMCT;
	}
}
