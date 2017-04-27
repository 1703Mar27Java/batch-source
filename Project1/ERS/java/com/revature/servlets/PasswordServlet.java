package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.User;
import com.revature.exceptions.PasswordException;
import com.revature.util.UserUtil;

public class PasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PasswordServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String password = request.getParameter("password");
		
		try {
			UserUtil.tryUpdatePassword(user, password, password);
			session.setAttribute("success", "Password successfully changed");
		} catch (PasswordException e) {
		}
	}

}
