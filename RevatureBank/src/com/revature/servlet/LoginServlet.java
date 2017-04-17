package com.revature.servlet;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.bean.Bank_User;
import com.revature.dao.*;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Bank_User user;
		try {
			Bank_UserDAO bank_UserDAO = new Bank_UserDAOImpl();
			
	        String userName = req.getParameter("userName");
	        String userPassword = req.getParameter("userPassword");
	        System.out.println(userName + userPassword);
	        int userId = bank_UserDAO.getUser(userName, userPassword);
	        user = new Bank_User(userId, userName, userPassword);

	        HttpSession session = req.getSession(); 
        	session.setAttribute("currentSessionUser", user); 
        	resp.sendRedirect("Welcome.jsp"); 
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
