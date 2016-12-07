package com.microlearn.entity.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

import com.microlearn.entity.Module;
import com.microlearn.entity.Teacher;
import com.microlearn.entity.dto.ModuleDto;

public class ModuleDAO {
	final String FIND_BY_TEACHER = "Select m FROM Module m WHERE m.teacher=:teacher";
	
	@PersistenceContext(unitName="MicroLearn")
	private EntityManager em;
	
	public boolean createModule(Teacher teacher, String title, String content) {
		Module module = new Module();
		module.setTeacher(teacher);
		module.setTitle(title);
		module.setContent(content);
		
		try {
			em.persist(module);
			return true;
		}
		catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			return false;
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
	
	public List<ModuleDto> getByTeacher(Teacher teacher) {
		List<Module> list = em.createQuery(FIND_BY_TEACHER, Module.class)
		.setParameter("teacher", teacher).getResultList();
		
		List<ModuleDto> modules = new ArrayList<ModuleDto>();
		for(Module module : list) {
			modules.add(new ModuleDto(module.getId(), module.getChapters(), module.getTitle(), module.getContent()));
		}
		return modules;
	}
}
