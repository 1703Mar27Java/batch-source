package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.domain.User;
import com.revature.exceptions.UsernameException;
import com.revature.util.MailUtil;
import com.revature.util.UserUtil;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		String email = request.getParameter("email");
		String manager = request.getParameter("manager");
		String role;
		if(manager.equals("on")){
			role = "MANAGER";
		} else {
			role = "ASSOCIATE";
		}
		
		String password = UserUtil.generateString(35, "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ", 8);
		
		
		try {
			UserUtil.tryCreate(new User(username, password, first, last, email, role));
			MailUtil.mail(email, password, username);
		} catch (UsernameException e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

}
