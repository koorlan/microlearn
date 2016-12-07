package com.microlearn.entity.dao;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TransactionRequiredException;

import org.apache.commons.codec.digest.DigestUtils;

import com.microlearn.entity.Account;
import com.microlearn.entity.Student;
import com.microlearn.entity.Teacher;
import com.microlearn.type.TAccount;

public class AccountDAO {

	@PersistenceContext(unitName="MicroLearn")
	private EntityManager em;
	
	public Account getAccount(String login) {
		return em.find(Account.class, login);
	}
	
	public boolean authenticate(String login, String password) {
		Account acc = getAccount(login);
		if(acc != null) {
			String pwd = DigestUtils.sha256Hex(password);
			return acc.getPassword().equals(pwd);
		}
		else
			return false;
	}
	
	public boolean addTeacher(String login, String password, String firstName, String lastName) {
		Teacher teacher = new Teacher();
		teacher.setLogin(login);
		teacher.setPassword(password);
		teacher.setFirstName(firstName);
		teacher.setLastName(lastName);
		
		try {
			em.persist(teacher);
			return true;
		}
		catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			return false;
		}
	}
	
	public boolean addStudent(String login, String password, String firstName, String lastName) {
		Student student = new Student();
		student.setLogin(login);
		student.setPassword(password);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		
		try {
			em.persist(student);
			return true;
		}
		catch (EntityExistsException | IllegalArgumentException | TransactionRequiredException e) {
			return false;
		}
	}
	
	public boolean removeAccount(String login) {
		Account acc = getAccount(login);
		if(acc != null)
		{
			if(acc.getType() == TAccount.TEACHER)
				return removeTeacher((Teacher)(acc));
			else if(acc.getType() == TAccount.STUDENT)
				return removeStudent((Student)(acc));
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean removeTeacher(Teacher teacher) {
		try{
			em.remove(teacher);
			return true;
		}
		catch (IllegalArgumentException | TransactionRequiredException e) {
			return false;
		}
	}
	
	public boolean removeStudent(Student student) {
		try{
			em.remove(student);
			return true;
		}
		catch (IllegalArgumentException | TransactionRequiredException e) {
			return false;
		}
	}
}