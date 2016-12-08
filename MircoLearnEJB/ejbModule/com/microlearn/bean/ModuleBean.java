package com.microlearn.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

import com.microlearn.entity.Account;
import com.microlearn.entity.Chapter;
import com.microlearn.entity.Module;
import com.microlearn.entity.Student;
import com.microlearn.entity.Teacher;
import com.microlearn.entity.dto.AttemptDto;
import com.microlearn.entity.dto.ChapterDto;
import com.microlearn.entity.dto.ModuleDto;

@LocalBean
@Stateless
public class ModuleBean {	
	@PersistenceContext(unitName="MicroLearn")
	private EntityManager em;
	
	public Module createModule(Teacher teacher, String title, String content) {
		Module module = new Module();
		module.setTeacher(teacher);
		module.setTitle(title);
		module.setContent(content);
		
		em.persist(module);
		return module;
	}
	
	public ModuleDto getModule(int id) {
		try {
			Module module = em.find(Module.class, id);
			return new ModuleDto(module.getId(),module.getChapters(), module.getTitle(),module.getTitle(),module.getTeacher());
		}
		catch(IllegalArgumentException e) {
			return null;
		}
	}
	
	public boolean delete(Module module) {
		try{
			em.remove(module);
			return true;
		}
		catch (IllegalArgumentException | TransactionRequiredException e) {
			return false;
		}
	}
	
	public boolean delete(int moduleId) {
		return delete(em.find(Module.class, moduleId));
	}

	public boolean updateTitle(int id, String title){
		try{
			Module module = em.find(Module.class, id);
			module.setTitle(title);
			return true;
		}
		catch (PersistenceException e) {
			return false;
		}
	}
	
	public boolean updateContent(int id, String content){
		try{
			Module module = em.find(Module.class, id);
			module.setContent(content);
			return true;
		}
		catch (PersistenceException e) {
			return false;
		}
	}
	
	public List<ModuleDto> getModules() {
		List<Module> list = em.createQuery("Select m FROM Module m", Module.class).getResultList();
		
		List<ModuleDto> modules = new ArrayList<ModuleDto>();
		for(Module module : list) {
			modules.add(new ModuleDto(module.getId(), module.getChapters(), module.getTitle(), module.getContent(), module.getTeacher()));
		}
		return modules;
	}
	
	public void subscribe(int moduleId, String studentLogin) {		
		Student student = (Student) em.find(Account.class, studentLogin);
		Module module =  em.find(Module.class, moduleId);
		
		if(module != null && student != null) {
			student.getFollowedModules().add(module);
			module.getFollowers().add(student);
		}
	}
	
	public int getLastSuccess(int moduleId, String studentLogin) {
		ModuleDto module = getModule(moduleId);
		int lastSuccess = -1;
		// Chapters are already sorted
		for(ChapterDto chapter : module.getChapters()) {
			if(chapter.getMct() == null) {
				break;
			}				
			for(AttemptDto attempt : chapter.getMct().getAttempts()) {
				if(attempt.isSuccess() && attempt.getUserLogin().equals(studentLogin)) {
					// MCT for the current chapter has been completed
					lastSuccess = chapter.getPosition();
				}
			}
		}
		return lastSuccess;
	}
}
