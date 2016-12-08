package com.microlearn.controler;

import java.io.IOException;


import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microlearn.bean.AccountBean;
import com.microlearn.bean.ModuleBean;
import com.microlearn.entity.Teacher;
import com.microlearn.type.TAccount;
import com.microlearn.entity.Account;
import com.microlearn.entity.Student;


/**
 * Servlet implementation class DefaultControler
 */
@WebServlet(name="DefaultControler", urlPatterns={"/DefaultControler"})
public class DefaultControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private ModuleBean serviceModule;
	@EJB
	private AccountBean serviceAccount;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DefaultControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String n_login = request.getParameter("login");
		String n_password = (String) request.getParameter("password");
		if ((n_login != null) && (n_password != null)) {
			Account acc = serviceAccount.authenticate(n_login, n_password);
			if (acc != null) { // User is authenticate, check if he's a teacher or a student
				if(acc.getType().equals(TAccount.TEACHER)) {
					request.getSession().setAttribute("account", (Teacher) acc);
					response.sendRedirect(request.getContextPath() + "/teacher");
				}
				else if(acc.getType().equals(TAccount.STUDENT)) {
					request.getSession().setAttribute("account", (Student) acc);
					response.sendRedirect(request.getContextPath() + "/student");
				}
				else
					response.sendRedirect(request.getContextPath());
			}
		}
	}
	
	public void refresh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account account = (Account) request.getSession().getAttribute("account");
		if(account == null){
			//We are not log in and we try to access index page so we redirect user to the login page
			request.getRequestDispatcher("/default/login.jsp").forward(request, response);
			return;
		}else{
			//redirect to student or teacher
			switch(account.getType()){
			case TAccount.STUDENT:
				request.getRequestDispatcher("/student").forward(request, response);
				return;
			case TAccount.TEACHER:
				request.getRequestDispatcher("/teacher").forward(request, response);
				return;
			// TODO : Admin ? lol TAccount.ADMIN
			default:
				//Why are we here  ? :p
				request.getRequestDispatcher("/default/login.jsp").forward(request, response);
				return;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
