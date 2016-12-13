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
		if(request.getAttribute("todo") != null && request.getAttribute("todo").equals("account_add")){
			if(request.getAttribute("login") != null && request.getAttribute("password") != null && request.getAttribute("firstname") != null && request.getAttribute("lastname") != null && request.getAttribute("acc_type") != null){
				String login = (String)request.getAttribute("login");
				String password = (String)request.getAttribute("password");
				String firstname = (String)request.getAttribute("firstname");
				String lastname = (String)request.getAttribute("lastname");
				
				
				String acc_type = (String) request.getAttribute("acc_type");
				switch(acc_type){
				case com.microlearn.type.TAccount.ADMIN:
					//TODO DANS ACCOUNT BEAN CREATION ADMIN
					break;
				case com.microlearn.type.TAccount.STUDENT:
					//TODO ATTENTION SHA256
					this.serviceAccount.addStudent(login, password, firstname, lastname);
					break;
				case com.microlearn.type.TAccount.TEACHER:
					//TODO ATTENTION SHA256
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
