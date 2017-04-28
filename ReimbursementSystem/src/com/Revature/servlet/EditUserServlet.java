package com.Revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.dao.UserDAOimpl;
import com.Revature.dao.UsernameExistsException;
import com.Revature.domain.User;

public class EditUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String n1 = req.getParameter("uname");
		String n2 = req.getParameter("password");
		String n3 = req.getParameter("fname");
		String n4 = req.getParameter("lname");
		String n5 = req.getParameter("email");
		User user = new User(n1, n2, n3, n4, n5, 1); //1 is assumed to be standard employee user role id
		UserDAOimpl userDAO = new UserDAOimpl();
		HttpSession session = req.getSession();
		User usersesh = (User) session.getAttribute("user");
		userDAO.editUser(usersesh.getUserID(), user);
		resp.sendRedirect("homepage.jsp");
	}
}
