package com.microlearn.entity.dto;

import java.util.ArrayList;
import java.util.List;

import com.microlearn.entity.Chapter;
import com.microlearn.entity.Module;

public class TeacherDto extends AccountDto {
	private List<ModuleDto> modules;

	public TeacherDto(String login, String firstName, String lastName, List<Module> modules) {
		super(login, firstName, lastName);
		this.modules = new ArrayList<ModuleDto>();
		for (Module m : modules) {
			this.modules.add(new ModuleDto(m.getId(), m.getChapters(), m.getTitle(), m.getContent(), m.getTeacher()));
		}
	}

	public List<ModuleDto> getModules() {
		return modules;
	}

}
