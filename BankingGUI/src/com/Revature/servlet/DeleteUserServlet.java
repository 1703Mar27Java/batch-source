package com.Revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.dao.UserDAOimpl;
import com.Revature.domain.User;

public class DeleteUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAOimpl userDAO = new UserDAOimpl();
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("viewuser");
		User superuser = (User) session.getAttribute("user");
		if (superuser.isSuperPriv()>0) {
				userDAO.deleteUser(user.getUserID());
				List<User> users = userDAO.retrieveAllUsers();
				session.setAttribute("users", users);
				resp.sendRedirect("userlist.jsp");
		} else {
			session.invalidate();
			req.setAttribute("message", "You are not allowed there");
			req.getRequestDispatcher("bankAfterLogin.jsp").forward(req, resp);
		}
	}
}
