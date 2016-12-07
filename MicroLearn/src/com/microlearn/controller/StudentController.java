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
		Account account = (Account) request.getSession().getAttribute("account");
		if(account != null && (account.getType() == TAccount.STUDENT) ){
			List<ModuleDto> modules = this.serviceModule.getModules();
	    	request.getSession().setAttribute("moduleList",new ArrayList<ModuleDto>(modules));
	    	request.getRequestDispatcher("/student/index.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/default").forward(request, response);
		} 	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
