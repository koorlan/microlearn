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

import com.microlearn.bean.ModuleBean;
import com.microlearn.entity.Account;
import com.microlearn.entity.Teacher;
import com.microlearn.entity.dto.ModuleDto;
import com.microlearn.type.TAccount;

/**
 * Servlet implementation class TeacherControler
 */
@WebServlet(name = "TeacherController", urlPatterns = { "/TeacherController" })
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ModuleBean serviceModule;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Teacher teacher = (Teacher) request.getSession().getAttribute("account");
		if (request.getParameter("todo") == null) {
			this.goHome(request, response);
		} else {
			switch (request.getParameter("todo")) {
			case "module_add":
				
				break;
			case "module_delete":

				break;
			case "module_edit":
				if(request.getParameter("title")!=null && request.getParameter("content")!= null && request.getParameter("id")!= null){
					//TODO : getModuleById and modify 
					this.goHome(request, response);
				}
				break;
			case "chapter_add":

				break;
			case "chapter_delete":

				break;
			case "chapter_edit":

				break;
			case "mct_add":

				break;
			case "mct_delete":

				break;
			case "mct_edit":

				break;
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
						case "add":
							break;
						case "delete":
							break;
						case "edit":
							List<ModuleDto> modules2 = this.serviceModule.getModules();
							for(ModuleDto m : modules2){
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
						case "add":
							break;
						case "delete":
							break;
						case "edit":
							break;
						default:
							this.goHome(request, response);
						}
						break;
					case "mct":
						switch(request.getParameter("action")){
						case "view":
							break;
						case "add":
							break;
						case "delete":
							break;
						case "edit":
							break;
						default:
							this.goHome(request, response);
						}
						break;
					default:
						this.goHome(request, response);
						break;
					}
					request.getRequestDispatcher("/teacher/"+request.getParameter("entity") + "/" + request.getParameter("action") +".jsp").forward(request, response);
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
		List<ModuleDto> modules = this.serviceModule.getModules();
		request.getSession().setAttribute("moduleList", new ArrayList<ModuleDto>(modules));
		request.getRequestDispatcher("/teacher/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
