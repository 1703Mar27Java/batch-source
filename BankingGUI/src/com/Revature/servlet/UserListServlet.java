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

public class UserListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		UserDAOimpl userDAO = new UserDAOimpl();
		List<User> users = userDAO.retrieveAllUsers();
		HttpSession session = req.getSession();
		session.setAttribute("users", users);
		resp.sendRedirect("userlist.jsp");
	}
}
