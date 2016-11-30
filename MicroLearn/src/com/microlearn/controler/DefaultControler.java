package com.microlearn.controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.microlearn.bean.AccountBean;
import com.microlearn.bean.ModuleBean;
import com.microlearn.entity.dto.ModuleDto;
import com.microlearn.entity.Teacher;
import com.microlearn.entity.Account;
import com.microlearn.entity.Student;


/**
 * Servlet implementation class DefaultControler
 */
@WebServlet("/DefaultControler")
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Account account = (Account) request.getSession().getAttribute("account");
		
		switch( (request.getParameter("todo") !=null ) ? request.getParameter("todo") : "refresh" ){ 	
    	
		
		case "log_in":
			if(account == null){
				String n_login = request.getParameter("login");
				String n_password = (String)request.getParameter("password");
				if((n_login != null) && (n_password != null)){
					Teacher accT = serviceAccount.getTeacher(n_login, DigestUtils.sha256Hex(n_password));
					if(accT != null){
						request.getSession().setAttribute("account", accT);
						request.getRequestDispatcher("/teacher").forward(request, response);
						return;
					}else{
						Student accS = serviceAccount.getStudent(n_login, DigestUtils.sha256Hex(n_password));
						if(accS != null){
							request.getSession().setAttribute("account", accS);
							request.getRequestDispatcher("/student").forward(request, response);
							return;
						}else{
						request.getRequestDispatcher("login.jsp").forward(request, response);
						return;
						}
					}	
				}
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		case "refresh":
			if(account == null){
				//We are not log in and we try to access index page so we redirect user to the login page
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}else{
				//redirect to student or teacher
				if(this.serviceAccount.getStudent(account.getLogin(),account.getPassword()) instanceof Student) {
					request.getRequestDispatcher("/student").forward(request, response);
					return;
				}else if(this.serviceAccount.getTeacher(account.getLogin(),account.getPassword()) instanceof Teacher){
					request.getRequestDispatcher("/teacher").forward(request, response);
					return;
				}	
				return;
			}
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
