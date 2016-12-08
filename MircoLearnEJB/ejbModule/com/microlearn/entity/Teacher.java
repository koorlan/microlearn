package com.microlearn.entity;

import java.util.List;

import javax.persistence.*;



@Entity
@DiscriminatorValue(com.microlearn.type.TAccount.TEACHER)
public class Teacher extends Account {
	
	@OneToMany(mappedBy="teacher", fetch = FetchType.EAGER)
	private List<Module> modules;

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	
	
}
