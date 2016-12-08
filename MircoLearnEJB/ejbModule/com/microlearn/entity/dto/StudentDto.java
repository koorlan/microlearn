package com.microlearn.entity.dto;

import java.util.List;

import com.microlearn.entity.Module;

public class StudentDto extends AccountDto {
	private List<Module> modules;

	public StudentDto(String login, String firstName, String lastName, List<Module> modules) {
		super(login, firstName, lastName);
		this.modules = modules;
	}
	
	public List<Module> getModules() {
		return modules;
	}
	
	
}
