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
		if (request.getParameter("todo") == null) {
			this.goHome(request, response);
		} else {
			switch (request.getParameter("todo")) {
			case "navigate":
				if(request.getParameter("entity")!=null && request.getParameter("action")!= null){
					switch(request.getParameter("entity")){
					case "module":
						switch(request.getParameter("action")){
						case "view":
							List<ModuleDto> modules = this.serviceModule.getModules();
							for(ModuleDto m : modules){
								if(m.getId() == Integer.parseInt(request.getParameter("id")))
									request.getSession().setAttribute("module", m);
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
							this.goHome(request, response);
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
					request.getRequestDispatcher("/student/"+request.getParameter("entity") + "/" + request.getParameter("action") +".jsp").forward(request, response);
				}else{
					this.goHome(request, response);
				}
				break;	
			default:
				this.goHome(request, response);
				break;
			}
		}
		
	}

	public void goHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO module du student
		List<ModuleDto> modules = this.serviceModule.getModules();
		request.getSession().setAttribute("moduleList", new ArrayList<ModuleDto>(modules));
		request.getRequestDispatcher("/student/index.jsp").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
