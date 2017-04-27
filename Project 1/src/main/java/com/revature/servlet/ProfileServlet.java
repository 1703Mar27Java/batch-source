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
			ERS_USERSDAO udao = new ERS_USERSDAOImpl();
			ERS_USERS updateUser = new ERS_USERS();

			updateUser.setU_USERNAME(req.getParameter("username"));
			updateUser.setU_PASSWORD(req.getParameter("password"));
			updateUser.setU_FIRSTNAME(req.getParameter("firstname"));
			updateUser.setU_LASTNAME(req.getParameter("lastname"));
			updateUser.setU_EMAIL(req.getParameter("email"));
			updateUser.setUR_ID(2);
	        
	        udao.save(updateUser);
	        
	        session.setAttribute("currentUser", updateUser);
        	resp.sendRedirect("main.jsp"); 
        } catch (SQLException e) {
        	req.setAttribute("message", "Failed to Update Profile");
        	req.getRequestDispatcher("main.jsp").forward(req, resp);
		}
	}
}
