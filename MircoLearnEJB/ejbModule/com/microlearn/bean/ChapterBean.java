package com.microlearn.bean;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

import com.microlearn.entity.Account;
import com.microlearn.entity.Attempt;
import com.microlearn.entity.Chapter;
import com.microlearn.entity.Module;
import com.microlearn.entity.MultipleChoiceTest;
import com.microlearn.entity.dto.ChapterDto;
import com.microlearn.entity.dto.MultipleChoiceTestDto;
import com.microlearn.entity.Student;

@LocalBean
@Stateless
public class ChapterBean {
	@PersistenceContext(unitName="MicroLearn")
	private EntityManager em;
	
	public ChapterDto getChapter(int id) {
		Chapter chapter = em.find(Chapter.class, id);
		return new ChapterDto(chapter.getId(),chapter.getModule(),chapter.getTitle(),
				chapter.getContent(),chapter.getPosition(), chapter.getMct());
	}
	
	public Chapter createChapter(String title, String content, int moduleId, int position) {
		Chapter chapter = new Chapter();
		chapter.setTitle(title);
		chapter.setContent(content);
		chapter.setModule(em.find(Module.class, moduleId));
		chapter.setPosition(position);
		
		em.persist(chapter);
		return chapter;
	}
	
	public boolean delete(int chapterId) {
		return delete(em.find(Chapter.class, chapterId));
	}
	
	public boolean delete(Chapter chapter) {
		try{
			em.remove(chapter);
			return true;
		}
		catch (IllegalArgumentException | TransactionRequiredException e) {
			return false;
		}
	}
	
	public boolean updateTitle(int id, String title){
		try{
			Chapter chapter = em.find(Chapter.class, id);
			chapter.setTitle(title);
			return true;
		}
		catch (PersistenceException e) {
			return false;
		}
	}
	
	public boolean updateContent(int id, String content){
		try{
			Chapter chapter = em.find(Chapter.class, id);
			chapter.setContent(content);
			return true;
		}
		catch (PersistenceException e) {
			return false;
		}
	}
	
	public MultipleChoiceTestDto getMct(int chapterId) {
		try{
			Chapter chapter = em.find(Chapter.class, chapterId);
			MultipleChoiceTest data = chapter.getMct();
			MultipleChoiceTestDto mct = new MultipleChoiceTestDto(data.getId(), data.getQuestions(), data.getAttempts(), data.getSuccessCondition());
			return mct;
		}
		catch (PersistenceException e) {
			return null;
		}
	}
	
	public void addAttempt(int mctId, String studentLogin, boolean success) {
		MultipleChoiceTest mct = em.find(MultipleChoiceTest.class, mctId);
		Student student = (Student) em.find(Account.class, studentLogin);
		Attempt attempt = new Attempt();
		attempt.setStudent(student);
		attempt.setMct(mct);
		attempt.setDate(new Date());
		attempt.setSuccess(success);
		
		em.persist(attempt);
	}
}
