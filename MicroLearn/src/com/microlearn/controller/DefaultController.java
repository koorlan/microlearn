package com.microlearn.controller;

import java.io.IOException;


import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.microlearn.bean.AccountBean;
import com.microlearn.bean.ModuleBean;
import com.microlearn.entity.Teacher;
import com.microlearn.type.TAccount;
import com.microlearn.entity.Account;
import com.microlearn.entity.Student;


/**
 * Servlet implementation class DefaultControler
 */
@WebServlet(name="DefaultController", urlPatterns={"/DefaultController"})
public class DefaultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private ModuleBean serviceModule;
	@EJB
	private AccountBean serviceAccount;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DefaultController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		switch(request.getParameter("todo")){
		case "log_in":
			this.log_in(request, response);
			return;
		case "log_out":
			this.log_out(request, response);
			return;
		default:
			break;
		}
		
	}
	
	public void log_in(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n_login = request.getParameter("login");
		String n_password = (String) request.getParameter("password");
		if ((n_login != null) && (n_password != null)) {
			Teacher accT = serviceAccount.getTeacher(n_login, DigestUtils.sha256Hex(n_password));
			if (accT != null) {
				request.getSession().setAttribute("account", accT);
				response.sendRedirect(request.getContextPath() + "/teacher");

			} else {
				Student accS = serviceAccount.getStudent(n_login, DigestUtils.sha256Hex(n_password));
				if (accS != null) {
					request.getSession().setAttribute("account", accS);
					response.sendRedirect(request.getContextPath() + "/student");
				} else {
					response.sendRedirect(request.getContextPath());
				}
			}
		}
	}

	public void log_out(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("account", null);
		response.sendRedirect(request.getContextPath());
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
