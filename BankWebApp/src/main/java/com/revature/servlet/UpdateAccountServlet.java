package com.revature.servlet;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.bean.*;
import com.revature.dao.*;

@SuppressWarnings("serial")
public class UpdateAccountServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			Bank_AccountDAO bank_AccountDAO = new Bank_AccountDAOImpl();
			Bank_User user = (Bank_User) session.getAttribute("sessionUser");
			
	        String accountIdStr = req.getParameter("accountId");
	        String accountName = req.getParameter("accountName");
	        int accountId = Integer.parseInt(accountIdStr);
	        
	        Bank_Account acc = new Bank_Account();	
	        acc.setBANK_ACCOUNT_ID(accountId);
	        acc.setBANK_USER_ID(user.getBANK_USER_ID());
	        acc.setBANK_ACCOUNT_NAME(accountName);
	        bank_AccountDAO.updateAccount(acc);
	        List<Bank_Account> accounts = bank_AccountDAO.getAccounts(user.getBANK_USER_ID());

        	session.setAttribute("sessionAccounts", accounts);
        	resp.sendRedirect("Welcome.jsp"); 
        } catch (SQLException e) {
		}
	}
}
