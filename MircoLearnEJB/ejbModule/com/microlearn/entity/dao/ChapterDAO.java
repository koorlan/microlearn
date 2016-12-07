package com.microlearn.entity.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

import com.microlearn.entity.Chapter;
import com.microlearn.entity.Module;
import com.microlearn.entity.dto.ChapterDto;

public class ChapterDAO {
	
	final String FIND_BY_MODULE = "Select c FROM Chapter c WHERE c.module.id=:moduleId";

	@PersistenceContext(unitName="MicroLearn")
	private EntityManager em;
	
	public boolean createChapter(String title, String content, Module module) {
		Chapter chapter = new Chapter();
		chapter.setTitle(title);
		chapter.setContent(content);
		chapter.setModule(module);
		
		try {
			em.persist(chapter);
			return true;
		}
		catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			return false;
		}
		
	}
	
	public List<ChapterDto> getByModule(int moduleId) {
		List<Chapter> list = em.createQuery(FIND_BY_MODULE, Chapter.class)
		.setParameter("moduleId", moduleId).getResultList();
		
		List<ChapterDto> chapters = new ArrayList<ChapterDto>();
		for(Chapter chapter : list) {
			// TODO are we sure we need the module in the ChapterDto ??
			chapters.add(new ChapterDto(chapter.getId(), chapter.getModule(), chapter.getTitle(), chapter.getContent()));
		}
		return chapters;
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
