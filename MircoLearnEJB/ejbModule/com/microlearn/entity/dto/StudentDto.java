package com.microlearn.entity.dto;

import java.util.ArrayList;
import java.util.List;

import com.microlearn.entity.Module;

public class StudentDto extends AccountDto {
	private List<ModuleDto> modules;

	public StudentDto(String login, String firstName, String lastName, List<Module> modules) {
		super(login, firstName, lastName);
		this.modules = new ArrayList<ModuleDto>();
		for(Module module : modules)
			this.modules.add(new ModuleDto(module.getId(), module.getChapters(), module.getTitle(), module.getContent()));
	}
	
	public List<ModuleDto> getModules() {
		return modules;
	}
	
	
}
