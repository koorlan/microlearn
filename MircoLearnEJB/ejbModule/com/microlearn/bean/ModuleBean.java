package com.microlearn.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;

import com.microlearn.entity.*;
import com.microlearn.entity.dto.*;

@Stateless
@LocalBean
public class ModuleBean {
	
	@PersistenceContext(unitName="MicroLearn")
	private EntityManager em;
	
	public List<ModuleDto> getModules(){
		List<Module> modules = em.createQuery("From Module m").getResultList();
		List<ModuleDto> modulesDto = new ArrayList<ModuleDto>();
		
		for(Module m : modules){
			modulesDto.add(new ModuleDto(m.getId(),m.getChapters(),m.getTitle(),m.getContent()));
		}
		return modulesDto;
	}
	

}
