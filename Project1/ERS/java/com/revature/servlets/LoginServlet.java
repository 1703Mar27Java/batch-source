package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.User;
import com.revature.exceptions.AuthenticationException;
import com.revature.util.UserUtil;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try {
			User user = UserUtil.tryLogin(username, password);
			session.setAttribute("user", user);
			if(user.getRole().equals("ASSOCIATE")){
				request.getRequestDispatcher("/associate.jsp").forward(request,response);
			} else {
				request.getRequestDispatcher("/manager.jsp").forward(request,response);
			}
		} catch (AuthenticationException e) {
			session.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
		
	}

}
