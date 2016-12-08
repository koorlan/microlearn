package com.microlearn.entity.dto;



public abstract class AccountDto {
	
	private String login;
	private String firstName;
	private String lastName;
	
	public AccountDto(String login, String firstName, String lastName) {
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getLogin() {
		return login;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}	
}
