package com.microlearn.bean;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

import com.microlearn.entity.Attempt;
import com.microlearn.entity.Chapter;
import com.microlearn.entity.Module;
import com.microlearn.entity.MultipleChoiceTest;
import com.microlearn.entity.Question;
import com.microlearn.entity.dto.ChapterDto;
import com.microlearn.entity.dto.MultipleChoiceTestDto;

@LocalBean
@Stateless
public class MultipleChoiceTestBean {
	@PersistenceContext(unitName="MicroLearn")
	private EntityManager em;

	public void createMCT(int chapterId, int successCondition){
		MultipleChoiceTest mct =new MultipleChoiceTest();
		mct.setChapter(em.find(Chapter.class,chapterId));
		mct.setSuccessCondition(successCondition);
	}
	
	public MultipleChoiceTestDto getMCT(int id){
		try{
			MultipleChoiceTest mct =  em.find(MultipleChoiceTest.class,id);
			Chapter c = mct.getChapter();
			ChapterDto cd = new ChapterDto(c.getId(),c.getModule(),c.getTitle(),c.getContent(),c.getPosition(),mct);
			
			return new MultipleChoiceTestDto(mct.getId(),mct.getQuestions(),mct.getAttempts(),mct.getSuccessCondition(),cd);
		}catch (Exception e){
			return null;
		}
	}
	
	public boolean delete(int mctId) {
		return delete(em.find(MultipleChoiceTest.class, mctId));
	}

	public boolean delete(MultipleChoiceTest mct) {
		try{
			em.remove(mct);
			return true;
		}
		catch (IllegalArgumentException | TransactionRequiredException e) {
			return false;
		}
	}
	
	
}
