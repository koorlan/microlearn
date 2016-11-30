package com.microlearn.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.microlearn.entity.Account;
import com.microlearn.entity.Student;
import com.microlearn.entity.Teacher;

@Stateless
@LocalBean
public class AccountBean {

	
	@PersistenceContext(unitName="MicroLearn")
	private EntityManager em;
	
	public Teacher getTeacher(String login, String password){
		try{
			Teacher acc = (Teacher) em.createQuery("Select a FROM Account a WHERE a.password=:password AND a.login=:login AND  TYPE(a) = Teacher",Account.class).setParameter("password", password).setParameter("login", login).getSingleResult();
			return acc;	
		} catch (NoResultException e){
			return null;
		}
	}
	
	public Student getStudent(String login, String password){
		try{
			Student acc = (Student) em.createQuery("Select a FROM Account a WHERE a.password=:password AND a.login=:login AND  TYPE(a) = Student",Account.class).setParameter("password", password).setParameter("login", login).getSingleResult();
			return acc;	
		} catch (NoResultException e){
			return null;
		}
	}
	
	
}
