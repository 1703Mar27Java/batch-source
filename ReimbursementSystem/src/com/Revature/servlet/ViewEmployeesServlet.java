package com.Revature.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.dao.UserDAOimpl;
import com.Revature.domain.User;

public class ViewEmployeesServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession();
		UserDAOimpl userDAO = new UserDAOimpl();
		List<User> users = userDAO.getAllUsers();
		session.setAttribute("users", users);
		resp.sendRedirect("viewemployees.jsp");
	}
}
