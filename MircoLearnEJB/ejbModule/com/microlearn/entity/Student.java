package com.microlearn.entity;

import java.util.List;

import javax.persistence.*;





@Entity
@DiscriminatorValue(com.microlearn.type.TAccount.STUDENT)
public class Student extends Account {
	
	@ManyToMany
	@JoinTable(name="FOLLOWING")
	private List<Module> followedModules;

	public List<Module> getFollowedModules() {
		return followedModules;
	}

	public void setFollowedModules(List<Module> modules) {
		this.followedModules = modules;
	}
	
}
