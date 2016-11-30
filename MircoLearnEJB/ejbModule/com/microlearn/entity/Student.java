package com.microlearn.entity;

import java.util.List;

import javax.persistence.*;





@Entity
@DiscriminatorValue(com.microlearn.type.TAccount.STUDENT)
public class Student extends Account {
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Module> modules;

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
}
