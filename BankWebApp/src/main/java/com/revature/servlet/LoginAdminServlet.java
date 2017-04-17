package com.revature.servlet;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.bean.*;
import com.revature.dao.*;

@SuppressWarnings("serial")
public class LoginAdminServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adminName = req.getParameter("adminName");
		String adminPassword = req.getParameter("adminPassword");
		Bank_UserDAO bank_UserDAO = new Bank_UserDAOImpl();

		if (adminName.equals("BankDB") && adminPassword.equals("p4ssw0rd")) {
			try {
				List<Bank_User> users = bank_UserDAO.getAllUsers();
				HttpSession session = req.getSession(); 
	        	session.setAttribute("sessionUsers", users); 
				resp.sendRedirect("AdminPage.jsp"); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			resp.sendRedirect("InvalidLogin.jsp");
		}
	}
}
