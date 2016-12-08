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
import com.microlearn.bean.ModuleBean;
import com.microlearn.entity.Account;
import com.microlearn.entity.Module;
import com.microlearn.entity.Student;
import com.microlearn.entity.Teacher;
import com.microlearn.entity.dto.ModuleDto;
import com.microlearn.type.TAccount;

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
		Student student = (Student) request.getSession().getAttribute("account");
		
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
			default:
				this.goHome(request, response);
				break;
			}
		}
		
	}
	
	private void naviguate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch(request.getParameter("entity")){
		case "module":
			switch(request.getParameter("action")) {
			case "view":
				if(request.getParameter("id") != null) {
					Module module = serviceModule.getModule(Integer.parseInt(request.getParameter("id")));
					request.getSession().setAttribute("module", module);
				}
				break;
			default:
				this.goHome(request, response);
			}
			break;
		case "chapter":
			switch(request.getParameter("action")){
			case "view":
				break;
			default:
				goHome(request, response);
			}
			break;
		case "mct":
			switch(request.getParameter("action")){
			case "view":
				break;
			default:
				this.goHome(request, response);
			}
			break;
		default:
			this.goHome(request, response);
			break;
		}
		
		request.getRequestDispatcher("/student/" + request.getParameter("entity") 
		+ "/" + request.getParameter("action") + ".jsp").forward(request, response);
	}

	public void goHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = (Student) request.getSession().getAttribute("account");
		if(student != null)
		{
			List<ModuleDto> modules = this.serviceModule.getModules();
			request.getSession().setAttribute("moduleList", new ArrayList<ModuleDto>(modules));
			
			// List<ModuleDto> myModules = serviceModule.getModulesByStudent(student);
			// request.setAttribute("myModules", myModules);

			request.getRequestDispatcher("/student/index.jsp").forward(request, response);
		}
		// @ TODO what's if there is no student ? Technically impossible ?
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
