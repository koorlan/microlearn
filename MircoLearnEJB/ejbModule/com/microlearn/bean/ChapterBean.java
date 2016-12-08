package com.microlearn.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

import com.microlearn.entity.Chapter;
import com.microlearn.entity.Module;
import com.microlearn.entity.dto.ChapterDto;

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
}
