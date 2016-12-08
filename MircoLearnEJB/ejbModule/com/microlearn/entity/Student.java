package com.microlearn.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue(com.microlearn.type.TAccount.STUDENT)
public class Student extends Account {
	
	@ManyToMany
	@JoinTable(name="FOLLOWING")
	private List<Module> followedModules;
	
	@OneToMany(mappedBy="student", cascade=CascadeType.REMOVE)
	private List<Attempt> attempts;

	public List<Module> getFollowedModules() {
		return followedModules;
	}

	public void setFollowedModules(List<Module> modules) {
		this.followedModules = modules;
	}

	public List<Attempt> getAttempts() {
		return attempts;
	}

	public void setAttempts(List<Attempt> attempts) {
		this.attempts = attempts;
	}
	
}
