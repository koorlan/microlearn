package com.microlearn.entity.dto;

import java.util.ArrayList;
import java.util.List;

import com.microlearn.entity.Attempt;
import com.microlearn.entity.Module;

public class StudentDto extends AccountDto {
	private List<ModuleDto> modules;
	private List<AttemptDto> attempts;
	
	public class Result {
		int chapterId;
		int attemptNumber;
		Attempt successAttempt;
		
		public Result(int chapterId, int attemptNumber, Attempt successAttempt) {
			this.chapterId = chapterId;
			this.attemptNumber = attemptNumber;
			this.successAttempt = successAttempt;
		}

		public int getChapterId() {
			return chapterId;
		}

		public int getAttemptNumber() {
			return attemptNumber;
		}

		public Attempt getSuccessAttempt() {
			return successAttempt;
		}
	};
	
	private List<Result> results;
	
	// Stores the last success of the student
	// for the Module that is analyzed by
	// the teacher. (Used only when students are
	// retrieved by the ModuleBean)
	private int lastSuccess;

	public StudentDto(String login, String firstName, String lastName, List<Module> modules, List<Attempt> attempts) {
		super(login, firstName, lastName);
		this.modules = new ArrayList<ModuleDto>();
		for(Module module : modules)
			this.modules.add(new ModuleDto(module.getId(), module.getChapters(), module.getTitle(), module.getContent(),module.getTeacher()));
		this.attempts = new ArrayList<AttemptDto>();
		for(Attempt attempt : attempts)
			this.attempts.add(new AttemptDto(attempt.getId(), attempt.getDate(), attempt.getScore(), login));
		this.results = new ArrayList<Result>();
	}
	
	public List<ModuleDto> getModules() {
		return modules;
	}

	public int getLastSuccess() {
		return lastSuccess;
	}

	public void setLastSuccess(int lastSuccess) {
		this.lastSuccess = lastSuccess;
	}
	
	public void addResult(int chapterId, int attemptNumber, Attempt successAttempt) {
		results.add(new Result(chapterId, attemptNumber, successAttempt));
	}
	
	public List<Result> getResults() {
		return this.results;
	}
}
