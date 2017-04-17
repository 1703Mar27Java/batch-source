package com.revature.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.bean.*;
import com.revature.dao.*;

@SuppressWarnings("serial")
public class DeleteUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Bank_UserDAO bank_UserDAO = new Bank_UserDAOImpl();
			
	        String userIdStr = req.getParameter("userId");
	        int userId = Integer.parseInt(userIdStr);
	        
	        Bank_User user = new Bank_User();
	        user.setBANK_USER_ID(userId);
	        bank_UserDAO.deleteUser(user);

        	resp.sendRedirect("AdminPage.jsp"); 
        } catch (SQLException e) {
		}
	}
}
