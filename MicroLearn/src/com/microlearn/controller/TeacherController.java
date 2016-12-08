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
import com.microlearn.entity.Chapter;
import com.microlearn.entity.Module;
import com.microlearn.entity.Teacher;
import com.microlearn.entity.dto.ModuleDto;
import com.microlearn.entity.dto.TeacherDto;
import com.microlearn.type.TAccount;

/**
 * Servlet implementation class TeacherControler
 */
@WebServlet(name = "TeacherController", urlPatterns = { "/TeacherController" })
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ModuleBean serviceModule;

	@EJB
	private AccountBean serviceAccount;

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
				if(request.getParameter("title")!=null && request.getParameter("content")!= null ){
					Module module = this.serviceModule.createModule(teacher, request.getParameter("title"), request.getParameter("content"));	
					request.setAttribute("module", new ModuleDto(module.getId(), module.getChapters(), module.getTitle(), module.getContent()));
					request.getRequestDispatcher("/teacher/module/view.jsp").forward(request, response);
				}
				break;
			case "module_delete":
				if(request.getParameter("id")!=null ){
					Module removed_module = null;
					removed_module = this.serviceModule.getModule(Integer.parseInt(request.getParameter("id")));
					if(removed_module != null && removed_module.getTeacher().getLogin().equals(teacher.getLogin())){
						this.serviceModule.delete(removed_module.getId());
					}
					this.goHome(request, response);
				}
				break;
			case "module_edit":
				if(request.getParameter("title")!=null && request.getParameter("content")!= null && request.getParameter("id")!= null){
					int id = Integer.parseInt(request.getParameter("id"));
					Module modified_module = null;	
					if(this.serviceModule.updateTitle(id,request.getParameter("title")) && this.serviceModule.updateContent(id,request.getParameter("content"))){
						modified_module = this.serviceModule.getModule(id);
						request.setAttribute("module", modified_module);
						request.getRequestDispatcher("/teacher/module/view.jsp").forward(request, response);
					}else{
						this.goHome(request, response);
					}
					
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
							if(request.getParameter("id") !=null){
								int id =Integer.parseInt(request.getParameter("id"));
								Module module = this.serviceModule.getModule(id);
								if(module.getTeacher().getLogin().equals(this.serviceAccount.getTeacher(teacher).getLogin())){
									request.setAttribute("module",module);
								}
							}
							break;
						case "edit":
							if(request.getParameter("id") !=null){
								for(Module module : this.serviceAccount.getTeacher(teacher).getModules()){
									if(module.getId() == Integer.parseInt(request.getParameter("id"))){
										request.setAttribute("module", new ModuleDto(module.getId(), module.getChapters(), module.getTitle(), module.getContent()));
										break;
									}			
								}			
							}
							break;
						case "add": //Keep thoses 2 lines (sort of filter for allowed action on module navigation -> else default and goHome Called otherwise let requestDispatcher to do the job)
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
		Teacher teacher = (Teacher) request.getSession().getAttribute("account");
		TeacherDto teacherDto = this.serviceAccount.getTeacher(teacher);
		
		List<ModuleDto> modules = new ArrayList<ModuleDto>();
		for(Module module : teacherDto.getModules()){
			modules.add(new ModuleDto(module.getId(), module.getChapters(), module.getTitle(), module.getContent()));
		}
		request.setAttribute("moduleList", modules);
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
