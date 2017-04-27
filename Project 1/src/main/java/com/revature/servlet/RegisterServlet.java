package com.revature.servlet;

import java.io.*;
import java.sql.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.bean.*;
import com.revature.dao.*;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
	        HttpSession session = req.getSession();
			ERS_USERSDAO udao = new ERS_USERSDAOImpl();
			ERS_USERS registerUser = new ERS_USERS();

	        registerUser.setU_USERNAME(req.getParameter("username"));
	        registerUser.setU_PASSWORD(req.getParameter("password"));
	        registerUser.setU_FIRSTNAME(req.getParameter("firstname"));
	        registerUser.setU_LASTNAME(req.getParameter("lastname"));
	        registerUser.setU_EMAIL(req.getParameter("email"));
	        registerUser.setUR_ID(2);
	        
	        udao.create(registerUser);
	        List<ERS_USERS> allEmployees = udao.loadAll();
	        
	        session.setAttribute("allEmployees", allEmployees);
        	resp.sendRedirect("main.jsp"); 
        } catch (SQLException e) {
        	req.setAttribute("message", "Failed to Register User");
        	req.getRequestDispatcher("main.jsp").forward(req, resp);
		}
	}
}
