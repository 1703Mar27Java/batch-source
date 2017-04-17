package com.revature.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.bean.*;
import com.revature.dao.*;

@SuppressWarnings("serial")
public class EditUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Bank_UserDAO bank_UserDAO = new Bank_UserDAOImpl();
			
	        String userIdStr = req.getParameter("userId");
	        int userId = Integer.parseInt(userIdStr);
	        String userName = req.getParameter("userName");
	        String userPassword = req.getParameter("userPassword");
	        Bank_User user = new Bank_User(userId, userName, userPassword);
	        bank_UserDAO.updateUser(user);;
	        
        	resp.sendRedirect("AdminPage.jsp"); 
        } catch (SQLException e) {
		}
	}
}
