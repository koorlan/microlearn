package com.microlearn.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

import com.microlearn.entity.Account;
import com.microlearn.entity.Attempt;
import com.microlearn.entity.Chapter;
import com.microlearn.entity.Module;
import com.microlearn.entity.MultipleChoiceTest;
import com.microlearn.entity.Student;
import com.microlearn.entity.Teacher;
import com.microlearn.entity.dto.AttemptDto;
import com.microlearn.entity.dto.ChapterDto;
import com.microlearn.entity.dto.ModuleDto;
import com.microlearn.entity.dto.StudentDto;

@LocalBean
@Stateless
public class ModuleBean {	
	@PersistenceContext(unitName="MicroLearn")
	private EntityManager em;
	
	public Module createModule(Teacher teacher, String title, String content) {
		Module module = new Module();
		module.setTeacher(teacher);
		module.setTitle(title);
		module.setContent(content);
		
		em.persist(module);
		return module;
	}
	
	public ModuleDto getModule(int id) {
		try {
			Module module = em.find(Module.class, id);
			return new ModuleDto(module.getId(),module.getChapters(), module.getTitle(),module.getContent(),module.getTeacher());
		}
		catch(IllegalArgumentException e) {
			return null;
		}
	}
	
	public boolean delete(Module module) {
		try{
			em.remove(module);
			return true;
		}
		catch (IllegalArgumentException | TransactionRequiredException e) {
			return false;
		}
	}
	
	public boolean delete(int moduleId) {
		return delete(em.find(Module.class, moduleId));
	}

	public boolean updateTitle(int id, String title){
		try{
			Module module = em.find(Module.class, id);
			module.setTitle(title);
			return true;
		}
		catch (PersistenceException e) {
			return false;
		}
	}
	
	public boolean updateContent(int id, String content){
		try{
			Module module = em.find(Module.class, id);
			module.setContent(content);
			return true;
		}
		catch (PersistenceException e) {
			return false;
		}
	}
	
	public List<ModuleDto> getModules() {
		List<Module> list = em.createQuery("Select m FROM Module m", Module.class).getResultList();
		
		List<ModuleDto> modules = new ArrayList<ModuleDto>();
		for(Module module : list) {
			modules.add(new ModuleDto(module.getId(), module.getChapters(), module.getTitle(), module.getContent(), module.getTeacher()));
		}
		return modules;
	}
	
	public void subscribe(int moduleId, String studentLogin) {		
		Student student = (Student) em.find(Account.class, studentLogin);
		Module module =  em.find(Module.class, moduleId);
		
		if(module != null && student != null) {
			student.getFollowedModules().add(module);
			module.getFollowers().add(student);
		}
	}
	
	public int getLastSuccess(int moduleId, String studentLogin) {
		ModuleDto module = getModule(moduleId);
		int lastSuccess = -1;
		// Chapters are already sorted
		for(ChapterDto chapter : module.getChapters()) {
			if(chapter.getMct() == null) {
				break;
			}				
			for(AttemptDto attempt : chapter.getMct().getAttempts()) {
				if(attempt.getScore() >= chapter.getMct().getSuccessCondition() 
						&& attempt.getUserLogin().equals(studentLogin)) {
					// MCT for the current chapter has been completed
					lastSuccess = chapter.getPosition();
				}
			}
		}
		return lastSuccess;
	}
	
	public boolean canReadChapter(int chapterId, String studentLogin) {
		Chapter chapter = em.find(Chapter.class, chapterId);
		int lastSuccess = getLastSuccess(chapter.getModule().getId(), studentLogin);
		if(lastSuccess == -1)
			lastSuccess = 0;
		return chapter.getPosition() <= lastSuccess + 1;
	}
	
	public int getChapterScore(int chapterId, String studentLogin) {
		Chapter chapter = em.find(Chapter.class, chapterId);
		MultipleChoiceTest mct = chapter.getMct();
		
		List<Attempt> attempts = mct.getAttempts();
		
		int score = -1;
		for(Attempt attempt : attempts) {
			if(attempt.getStudent().getLogin().equals(studentLogin) &&
					score < attempt.getScore()) {
				score = attempt.getScore();
			}
		}
		
		if(score < mct.getSuccessCondition())
			score = -1;
		
		return score;
	}
	
	public List<StudentDto> getStudents(int moduleId) {
		Module module = em.find(Module.class, moduleId);
		List<Student> list = module.getFollowers();
		
		List<StudentDto> students = new ArrayList<StudentDto>();
		for(Student student : list) {
			StudentDto dto = new StudentDto(student.getLogin(), student.getFirstName(), student.getLastName(),
					student.getFollowedModules(), student.getAttempts());
			dto.setLastSuccess(this.getLastSuccess(moduleId, student.getLogin()));
			students.add(dto);
		}
		return students;
	}
	
	public StudentDto getStudent(String login, int moduleId) {
		Student data = em.find(Student.class, login);
		StudentDto student = new StudentDto(data.getLogin(), data.getFirstName(), data.getLastName(),
				data.getFollowedModules(), data.getAttempts());
		Module module = em.find(Module.class, moduleId);
		int lastSuccess = getLastSuccess(moduleId, login);
		student.setLastSuccess(lastSuccess);
		
		for(Chapter chapter : module.getChapters()) {
			if(chapter.getPosition() <= lastSuccess) {
				List<Attempt> attempts = em.createQuery("Select a From Attempt a Where mct = :mct And student = :student Order By DATE")
						.setParameter("mct", chapter.getMct()).setParameter("student", data).getResultList();
				Attempt success = null;
				if(attempts.get(attempts.size() - 1).getScore() >= chapter.getMct().getSuccessCondition())
					success = attempts.get(attempts.size() - 1);
				student.addResult(chapter.getId(), attempts.size(), success);
			}
		}
		
		return student;
	}
}
