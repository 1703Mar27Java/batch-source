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

public class ViewUserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Integer uid = Integer.parseInt(req.getParameter("uid"));
		HttpSession session = req.getSession();
		UserDAOimpl userDAO = new UserDAOimpl();
		User user = userDAO.getUserByID(uid);
		session.setAttribute("viewuser", user);
		resp.sendRedirect("viewuser.jsp");
	}
}
