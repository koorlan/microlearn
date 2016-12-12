package com.microlearn.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

import com.microlearn.entity.Answer;
import com.microlearn.entity.Chapter;
import com.microlearn.entity.MultipleChoiceTest;
import com.microlearn.entity.Question;
import com.microlearn.entity.dto.MultipleChoiceTestDto;

@LocalBean
@Stateless
public class MultipleChoiceTestBean {
	@PersistenceContext(unitName="MicroLearn")
	private EntityManager em;

	public MultipleChoiceTest createMCT(int chapterId, int successCondition){
		MultipleChoiceTest mct =new MultipleChoiceTest();
		mct.setChapter(em.find(Chapter.class,chapterId));
		mct.setSuccessCondition(successCondition);
		
		em.persist(mct);
		return mct;
	}
	
	public MultipleChoiceTestDto getMCT(int id){
		try{
			MultipleChoiceTest mct =  em.find(MultipleChoiceTest.class,id);			
			return new MultipleChoiceTestDto(mct.getId(),mct.getQuestions(),mct.getAttempts(),
					mct.getSuccessCondition(), mct.getShowAnswers());
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
	
	public Question createQuestion(int mct_id, String text){
		Question q = new Question();
		q.setQuestionText(text);
		
		MultipleChoiceTest mct = em.find(MultipleChoiceTest.class, mct_id);
		q.setMct(mct);
		mct.getQuestions().add(q);
		em.persist(q);
		
		return q;
	}
	
	public Answer createAnswer(int q_id, String text, boolean isTrue){
		Answer a = new Answer();
		a.setText(text);
		a.setTrue(isTrue);
		
		Question q = em.find(Question.class, q_id);
		a.setQuestion(q);
		q.getAnswers().add(a);
		em.persist(a);
		
		return a;
	}
}
