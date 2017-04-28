package com.revature.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.bean.*;
import com.revature.dao.*;

@SuppressWarnings("serial")
public class ProfileServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			ERS_USERS currentUser = (ERS_USERS) session.getAttribute("currentUser");
			ERS_USERSDAO udao = new ERS_USERSDAOImpl();

			currentUser.setU_USERNAME(req.getParameter("username"));
			currentUser.setU_PASSWORD(req.getParameter("password"));
			currentUser.setU_FIRSTNAME(req.getParameter("firstname"));
			currentUser.setU_LASTNAME(req.getParameter("lastname"));
			currentUser.setU_EMAIL(req.getParameter("email"));
			currentUser.setUR_ID(2);
	        
	        udao.save(currentUser);
	        
	        session.setAttribute("currentUser", currentUser);
        	resp.sendRedirect("main.jsp"); 
        } catch (SQLException e) {
        	req.setAttribute("message", "Failed to Update Profile");
        	req.getRequestDispatcher("main.jsp").forward(req, resp);
		}
	}
}
