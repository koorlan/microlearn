package com.microlearn.entity.dto;



public abstract class AccountDto {
	
	private String login;
	private String password;
	private String type;
	private String firstName;
	private String lastName;
	
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public String getType() {
		return type;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}

	
	
}
