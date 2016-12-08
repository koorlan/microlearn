package com.microlearn.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

import com.microlearn.entity.Chapter;
import com.microlearn.entity.Module;

@LocalBean
@Stateless
public class ChapterBean {
	
	final String FIND_BY_MODULE = "Select c FROM Chapter c WHERE c.module.id=:moduleId";

	@PersistenceContext(unitName="MicroLearn")
	private EntityManager em;
	
	public Chapter createChapter(String title, String content, Module module) {
		Chapter chapter = new Chapter();
		chapter.setTitle(title);
		chapter.setContent(content);
		chapter.setModule(module);
		
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
}
