package com.revature.servlet;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.bean.*;
import com.revature.dao.*;

@SuppressWarnings("serial")
public class OpenAccountServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			Bank_AccountDAO bank_AccountDAO = new Bank_AccountDAOImpl();
			Bank_User user = (Bank_User) session.getAttribute("sessionUser");
			
	        String accountName = req.getParameter("accountName");
	        
	        Bank_Account acc = new Bank_Account(user.getBANK_USER_ID(), accountName);	
	        bank_AccountDAO.createAccount(acc);
	        List<Bank_Account> accounts = bank_AccountDAO.getAccounts(user.getBANK_USER_ID());

        	session.setAttribute("sessionAccounts", accounts);
        	resp.sendRedirect("Welcome.jsp"); 
        } catch (SQLException e) {
		}
	}
}
