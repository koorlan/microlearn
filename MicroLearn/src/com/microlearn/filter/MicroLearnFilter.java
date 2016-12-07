package com.microlearn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.microlearn.entity.Account;
import com.microlearn.type.TAccount;

public  class MicroLearnFilter  implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");
        if ( account == null ) {
        	String todo = (String) request.getParameter("todo");
        	if(todo != null && todo.equals("log_in")){
        		//request.getRequestDispatcher("/default").forward(request, response);
        		chain.doFilter(request, response);
        		return;
        	}else{
        		request.getRequestDispatcher("/default/login.jsp").forward(request, response);
        		return;
        	}   	
        } else {
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

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}