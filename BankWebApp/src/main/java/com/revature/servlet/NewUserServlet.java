package com.revature.servlet;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.bean.*;
import com.revature.dao.*;

@SuppressWarnings("serial")
public class NewUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Bank_UserDAO bank_UserDAO = new Bank_UserDAOImpl();
			Bank_AccountDAO bank_AccountDAO = new Bank_AccountDAOImpl();
			Bank_TransactionDAO bank_TransactionDAO = new Bank_TransactionDAOImpl();
			
	        String userName = req.getParameter("userName");
	        String userPassword = req.getParameter("userPassword");
	        Bank_User user = new Bank_User(userName, userPassword);
	        bank_UserDAO.createUser(user);
	    
	        int userId = bank_UserDAO.getUser(userName, userPassword);
	        user.setBANK_USER_ID(userId);
	        
	        List<Bank_Account> accounts = bank_AccountDAO.getAccounts(userId);
	        List<Bank_Transaction> transactions = bank_TransactionDAO.getTransactions(userId);
	        

	        HttpSession session = req.getSession(); 
        	session.setAttribute("sessionUser", user); 
        	session.setAttribute("sessionAccounts", accounts);
        	session.setAttribute("sessionTransactions", transactions);
        	resp.sendRedirect("Welcome.jsp"); 
        } catch (SQLException e) {
        	req.setAttribute("message", "Failed to Create User");
        	req.getRequestDispatcher("InvalidLogin.jsp").forward(req, resp);
		}
	}
}
