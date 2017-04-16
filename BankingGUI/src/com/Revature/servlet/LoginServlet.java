package com.Revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.dao.IncorrectLoginException;
import com.Revature.dao.UserDAOimpl;
import com.Revature.domain.BankAccount;
import com.Revature.domain.User;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// writing directly to response body
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		UserDAOimpl userDAO = new UserDAOimpl();
		User user = new User();
		try {
			user = userDAO.UserByLogin(n1, n2);
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			List<BankAccount> accts = userDAO.retrieveAccounts(user.getUserID());
			session.setAttribute("accounts", accts);
			resp.sendRedirect("homepage.jsp");
		} catch (IncorrectLoginException e) {
			req.setAttribute("message", "Failed to Login");
			req.getRequestDispatcher("bankAfterLogin.jsp").forward(req, resp);
		}
	}
}
