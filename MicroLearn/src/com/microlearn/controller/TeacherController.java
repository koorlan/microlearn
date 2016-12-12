package com.microlearn.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlearn.bean.AccountBean;
import com.microlearn.bean.ChapterBean;
import com.microlearn.bean.ModuleBean;
import com.microlearn.bean.MultipleChoiceTestBean;
import com.microlearn.entity.Chapter;
import com.microlearn.entity.Module;
import com.microlearn.entity.MultipleChoiceTest;
import com.microlearn.entity.Question;
import com.microlearn.entity.Teacher;
import com.microlearn.entity.dto.ChapterDto;
import com.microlearn.entity.dto.ModuleDto;
import com.microlearn.entity.dto.MultipleChoiceTestDto;
import com.microlearn.entity.dto.TeacherDto;

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

	@EJB
	private ChapterBean serviceChapter;
	
	@EJB
	private MultipleChoiceTestBean serviceMct;

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
					request.setAttribute("module", serviceModule.getModule(module.getId()));
					request.getRequestDispatcher("/teacher/module/view.jsp").forward(request, response);
				}
				break;
			case "module_delete":
				if(request.getParameter("id")!=null ){
					ModuleDto removed_module = null;
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
					ModuleDto modified_module = null;	
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
				if(request.getParameter("title")!=null && request.getParameter("content")!= null && request.getParameter("module_id")!= null){
					String title = request.getParameter("title");
					String content = request.getParameter("content");
					int module_id = Integer.parseInt(request.getParameter("module_id"));			
					int position = this.serviceModule.getModule(module_id).getChapters().size()+1;				
					Chapter chapter = this.serviceChapter.createChapter(title, content, module_id, position);
					
					MultipleChoiceTest mct = this.serviceMct.createMCT(chapter.getId(), 0);
					//this.serviceChapter.updateMct(chapter.getId(), mct);
					
					request.setAttribute("mct", this.serviceMct.getMCT(mct.getId()));
					request.getRequestDispatcher("/teacher/mct/edit.jsp").forward(request, response);
				}
				break;
			case "chapter_delete":
				if(request.getParameter("id")!=null){
					ChapterDto removed_chapter = null;
					removed_chapter = this.serviceChapter.getChapter(Integer.parseInt(request.getParameter("id")));
					if(removed_chapter != null && removed_chapter.getModule().getTeacher().getLogin().equals(teacher.getLogin())){
						this.serviceChapter.delete(removed_chapter.getId());
					}
					ModuleDto module = this.serviceModule.getModule(removed_chapter.getModule().getId());
					if(module.getTeacher().getLogin().equals(this.serviceAccount.getTeacher(teacher).getLogin())){
						request.setAttribute("module",module);
					}
					request.getRequestDispatcher("/teacher/module/view.jsp").forward(request, response);
					return;
				}
				break;
			case "chapter_edit":
				if(request.getParameter("title")!=null && request.getParameter("content")!= null && request.getParameter("id")!= null){
					int id = Integer.parseInt(request.getParameter("id"));
					ChapterDto modified_chapter = null;	
					if(this.serviceChapter.updateTitle(id,request.getParameter("title")) && this.serviceChapter.updateContent(id,request.getParameter("content"))){
						modified_chapter = this.serviceChapter.getChapter(id);
						request.setAttribute("chapter", modified_chapter);
						request.getRequestDispatcher("/teacher/chapter/view.jsp").forward(request, response);
					}else{
						this.goHome(request, response);
					}
					
				}
				break;
			case "mct_delete":
				
				break;
			case "mct_edit":
				
				break;
			case "question_add":
				if(request.getParameter("mct_id")!=null && !request.getParameter("0").isEmpty() && !request.getParameter("question").isEmpty()){
					int mct_id = Integer.parseInt(request.getParameter("mct_id"));
					int answer_counter = Integer.parseInt(request.getParameter("answer_counter"));
					
					String questionText = request.getParameter("question");
					Question q = this.serviceMct.createQuestion(mct_id,questionText);
					
					for(int i=0; i<answer_counter;i++){
						if(!request.getParameter(Integer.toString(i)).isEmpty()){
							boolean isTrue = false;
							if( request.getParameter(Integer.toString(i)+"_t")!=null && request.getParameter(Integer.toString(i)+"_t").equals("on")){
								isTrue = true;
							}
							this.serviceMct.createAnswer(q.getId(),request.getParameter(Integer.toString(i)),isTrue);
						}
					}
					MultipleChoiceTestDto mct = this.serviceMct.getMCT(mct_id);
					request.setAttribute("mct", mct);
					request.getRequestDispatcher("/teacher/mct/edit.jsp").forward(request, response);
				}
				break;
			case "navigate":
				if(request.getParameter("entity")!=null && request.getParameter("action")!= null){
					switch(request.getParameter("entity")){
					case "module":
						switch(request.getParameter("action")){
						case "view":
							if(request.getParameter("id") !=null){
								int id =Integer.parseInt(request.getParameter("id"));
								ModuleDto module = this.serviceModule.getModule(id);
								if(module.getTeacher().getLogin().equals(this.serviceAccount.getTeacher(teacher).getLogin())){
									request.setAttribute("module",module);
								}
							}
							break;
						case "edit":
							if(request.getParameter("id") !=null){
								int id =Integer.parseInt(request.getParameter("id"));
								ModuleDto module = this.serviceModule.getModule(id);
								if(module.getTeacher().getLogin().equals(this.serviceAccount.getTeacher(teacher).getLogin())){
									request.setAttribute("module",module);
								}	
							}
							break;
						case "add": //Keep thoses 2 lines (sort of filter for allowed action on navigation -> else default and goHome Called otherwise let requestDispatcher to do the job)
							break;
						default:
							this.goHome(request, response);
						}
						break;
					case "chapter":
						switch(request.getParameter("action")){
						case "view":
							if(request.getParameter("id") !=null){
								int id =Integer.parseInt(request.getParameter("id"));
								ChapterDto chapter = this.serviceChapter.getChapter(id);
								if(chapter.getModule().getTeacher().getLogin().equals(teacher.getLogin())){
									request.setAttribute("chapter", chapter);
								}
							}
							break;
						case "add":
							if(request.getParameter("module_id") != null){
								request.setAttribute("module_id", Integer.parseInt(request.getParameter("module_id")));
							}else{
								this.goHome(request, response);
								return;
							}
							break;
						case "edit":
							if(request.getParameter("id") !=null){
								int id =Integer.parseInt(request.getParameter("id"));
								ChapterDto chapter = this.serviceChapter.getChapter(id);
								if(chapter.getModule().getTeacher().getLogin().equals(teacher.getLogin())){
									request.setAttribute("chapter", chapter);
								}
							}
							break;
						default:
							this.goHome(request, response);
						}
						break;
					case "mct":
						switch(request.getParameter("action")){
						case "view":
							if(request.getParameter("id") !=null){
								int id = Integer.parseInt(request.getParameter("id"));
								if(serviceMct.canAccess(id, teacher.getLogin())) {
									MultipleChoiceTestDto mct = this.serviceMct.getMCT(id);
									request.setAttribute("mct", mct);
								}
							}
							break;
						case "add":
							if(request.getParameter("chapter_id") != null){
								request.setAttribute("chapter_id", Integer.parseInt(request.getParameter("chapter_id")));
							}else{
								this.goHome(request, response);
								return;
							}
							break;
						case "delete":
							break;
						case "edit":
							if(request.getParameter("id") !=null){
								int id = Integer.parseInt(request.getParameter("id"));
								if(serviceMct.canAccess(id, teacher.getLogin())) {
									MultipleChoiceTestDto mct = this.serviceMct.getMCT(id);
									request.setAttribute("mct", mct);
								}
							}
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

		request.setAttribute("moduleList", teacherDto.getModules());
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
