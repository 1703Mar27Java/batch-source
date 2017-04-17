package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bankExceptions.PasswordException;
import com.revature.bankExceptions.UserNameAlreadyExistsException;
import com.revature.domain.User;
import com.revature.util.UserUtil;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
			try {
				User user = UserUtil.tryCreate(username, password, confirm);
				System.out.println(user.getUsername());
				session.setAttribute("user", user);
				session.setAttribute("success", "Successfully created user '"+username+"'");
				response.sendRedirect("main.jsp");
			} catch (UserNameAlreadyExistsException e) {
				session.setAttribute("error", e.getMessage());
				response.sendRedirect("register.jsp");
			} catch (PasswordException e) {
				session.setAttribute("error", e.getMessage());
				
			}	
	}
}
