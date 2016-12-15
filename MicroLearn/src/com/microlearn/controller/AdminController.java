package com.microlearn.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlearn.bean.AccountBean;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private AccountBean serviceAccount;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("todo") != null && request.getParameter("todo").equals("account_add")){
			if(		request.getParameter("login") != null && 
					request.getParameter("password") != null &&
					request.getParameter("firstname") != null &&
					request.getParameter("lastname") != null){

				String login = (String)request.getParameter("login");
				String password = (String)request.getParameter("password");
				String firstname = (String)request.getParameter("firstname");
				String lastname = (String)request.getParameter("lastname");
				
				
				String acc_type = (String) request.getParameter("acc_type");
				switch(acc_type){
				case com.microlearn.type.TAccount.ADMIN:
					this.serviceAccount.addAdmin(login, password, firstname, lastname);
					break;
				case com.microlearn.type.TAccount.STUDENT:
					this.serviceAccount.addStudent(login, password, firstname, lastname);
					break;
				case com.microlearn.type.TAccount.TEACHER:
					this.serviceAccount.addTeacher(login, password, firstname, lastname);
					break;
				default:
					break;
				}
			}
		}
		
		request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
