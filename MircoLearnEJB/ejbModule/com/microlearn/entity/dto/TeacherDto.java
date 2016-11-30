package com.microlearn.entity.dto;

import java.util.List;

import com.microlearn.entity.Module;

public class TeacherDto extends AccountDto{
	private List<Module> modules;

	public List<Module> getModules() {
		return modules;
	}
	
	
}
