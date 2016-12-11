package com.microlearn.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

import com.microlearn.entity.Chapter;
import com.microlearn.entity.MultipleChoiceTest;
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
			return new MultipleChoiceTestDto(mct.getId(),mct.getQuestions(),mct.getAttempts(),mct.getSuccessCondition());
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
	
	public boolean canAccess(int mctId, String teacherLogin) {
		MultipleChoiceTest mct = em.find(MultipleChoiceTest.class, mctId);
		return mct.getChapter().getModule().getTeacher().getLogin().equals(teacherLogin);
	}
}
