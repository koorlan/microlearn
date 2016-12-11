package com.microlearn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlearn.bean.AccountBean;
import com.microlearn.bean.ChapterBean;
import com.microlearn.bean.ModuleBean;
import com.microlearn.entity.Account;
import com.microlearn.entity.Student;
import com.microlearn.entity.dto.AnswerDto;
import com.microlearn.entity.dto.ChapterDto;
import com.microlearn.entity.dto.ModuleDto;
import com.microlearn.entity.dto.MultipleChoiceTestDto;
import com.microlearn.entity.dto.QuestionDto;
import com.microlearn.entity.dto.StudentDto;

/**
 * Servlet implementation class StudentControler
 */
@WebServlet(name="StudentController", urlPatterns={"StudentController"})
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private ModuleBean serviceModule;
	@EJB
	private AccountBean serviceAccount;
	@EJB
	private ChapterBean serviceChapter;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("todo") == null)
			this.goHome(request, response);
		else {
			switch (request.getParameter("todo")) {
			case "navigate":
				if(request.getParameter("entity")!=null && request.getParameter("action")!= null)
					naviguate(request, response);
				else
					this.goHome(request, response);
				break;
			case "answer":
				if(request.getParameter("chapter_id") != null)
					answerMct(request, response, Integer.parseInt(request.getParameter("chapter_id")));
				break;
			default:
				this.goHome(request, response);
				break;
			}
		}
		
	}
	
	private void naviguate(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Student student =  (Student) request.getSession().getAttribute("account");
		switch(request.getParameter("entity")){
		case "module":
			naviguateMenu(request, response, student);
			break;
		case "chapter":
			naviguateChapter(request, response, student);
			break;
		default:
			this.goHome(request, response);
			return;
		}
		
		request.getRequestDispatcher("/student/" + request.getParameter("entity") 
		+ "/" + request.getParameter("action") + ".jsp").forward(request, response);
	}

	private void naviguateMenu(HttpServletRequest request, HttpServletResponse response, Student student) 
			throws ServletException, IOException {
		switch(request.getParameter("action")) {
		case "view":
			if(request.getParameter("id") != null) {
				ModuleDto module = serviceModule.getModule(Integer.parseInt(request.getParameter("id")));
				int lastSuccess = serviceModule.getLastSuccess(module.getId(), student.getLogin());
				request.setAttribute("module", module);
				request.setAttribute("lastSuccess", lastSuccess);
			}
			break;
		case "subscribe":
			if(request.getParameter("id") != null) {
				int moduleId = Integer.parseInt(request.getParameter("id"));
				serviceModule.subscribe(moduleId, ((Account)request.getSession().getAttribute("account")).getLogin());
			}
			goHome(request, response);
			return;
		default:
			this.goHome(request, response);
			return;
		}
	}
	
	private void naviguateChapter(HttpServletRequest request, HttpServletResponse response, Student student) 
			throws ServletException, IOException {
		switch(request.getParameter("action")) {
		case "view":
			int chapterId = Integer.parseInt(request.getParameter("id"));
			if(serviceModule.canReadChapter(chapterId, student.getLogin())) {
				ChapterDto chapter = serviceChapter.getChapter(chapterId);
				request.setAttribute("chapter", chapter);
			}
			else {
				goHome(request, response);
				return;
			}
			break;
		default:
			goHome(request, response);
			return;
		}
	}
	
	private void goHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDto student = serviceAccount.getStudent((Account)request.getSession().getAttribute("account"));
		if(student != null)
		{
			List<ModuleDto> modules = serviceModule.getModules();
			List<ModuleDto> toRemove = new ArrayList<ModuleDto>();
			for(ModuleDto module : modules) {
				for(ModuleDto mine : student.getModules()) {
					if(module.getId() == mine.getId()) {
						toRemove.add(module);
						break;
					}
				}
			}
			
			modules.removeAll(toRemove);
			request.setAttribute("modules", new ArrayList<ModuleDto>(modules));
			request.setAttribute("student", student);

			request.getRequestDispatcher("/student/index.jsp").forward(request, response);
		}
		// @ TODO what's if there is no student ? Technically impossible ?
	}
	
	private void answerMct(HttpServletRequest request, HttpServletResponse response, int chapterId) throws ServletException, IOException  {
		Student student = (Student) request.getSession().getAttribute("account");
		
		MultipleChoiceTestDto mct = serviceChapter.getMct(chapterId);
		if(mct == null) {
			goHome(request, response);
			return;
		}
		int correctAnswers = 0;
		for(QuestionDto question : mct.getQuestions()) {    // For each question of the mct
			boolean isIncorrect = false;					// if at least one bad answer is
			for(AnswerDto answer : question.getAnswers()) { // selected, then the question
				if(!answer.isTrue()) {						// is not properly answered
					if(request.getParameter("answer-" + String.valueOf(answer.getId())) != null &&
							request.getParameter("answer-" + String.valueOf(answer.getId())).equals("on"))
						isIncorrect = true;
				}
			}
			if(!isIncorrect)
				correctAnswers++;
		}
		
		boolean isSuccess = correctAnswers >= mct.getSuccessCondition();
		serviceChapter.addAttempt(mct.getId(), student.getLogin(), isSuccess);
		
		request.getRequestDispatcher("StudentController?&todo=naviguate&entity=chapter&action=view&id=" + String.valueOf(chapterId))
		.forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
