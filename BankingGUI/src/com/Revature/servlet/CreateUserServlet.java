package com.Revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.dao.UserDAOimpl;
import com.Revature.domain.User;

public class CreateUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		User user = new User(n1, n2, 0);
		UserDAOimpl userDAO = new UserDAOimpl();
		userDAO.createUser(user);
		HttpSession session = req.getSession();
		User superuser = (User) session.getAttribute("user");
		if(superuser != null){
			session.setAttribute("user", superuser);
		}else{
			session.setAttribute("user", user);
		}
		resp.sendRedirect("homepage.jsp");
	}
}
