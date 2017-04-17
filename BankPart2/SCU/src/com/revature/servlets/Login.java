package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bankExceptions.PasswordException;
import com.revature.dao.BankDAOImp;
import com.revature.domain.User;
import com.revature.util.UserUtil;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		User user = new User();
		try {
			user = UserUtil.tryLogin(username, password);
			session.setAttribute("user", user);
			BankDAOImp dao = new BankDAOImp();
			dao.getAccounts(user);
			if (username.equals("SUPER")) {
				session.setAttribute("super", "true");
				response.sendRedirect("super.jsp");
			} else {
				response.sendRedirect("main.jsp");
			}
		} catch (PasswordException e) {
			session.setAttribute("error", "*Invalid username or password");
			response.sendRedirect("Login.jsp");
		}
	}

}
