package com.revature.servlet;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.bean.*;
import com.revature.dao.*;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
	        HttpSession session = req.getSession();
			ERS_USERSDAO udao = new ERS_USERSDAOImpl();
			ERS_REIMBURSEMENTSDAO rdao = new ERS_REIMBURSEMENTSDAOImpl();
			
	        String username = req.getParameter("username");
	        String password = req.getParameter("password");
	        
	        ERS_USERS currentUser = udao.search(username, password);
	        List<ERS_REIMBURSEMENTS> reimbursements = rdao.loadAll();
	        List<ERS_USERS> allEmployees = udao.loadAll();
	        
	        session.setAttribute("allEmployees", allEmployees);
	        session.setAttribute("currentUser", currentUser);
        	session.setAttribute("reimbursements", reimbursements);
        	resp.sendRedirect("main.jsp"); 
        } catch (SQLException e) {
        	req.setAttribute("message", "Failed to Login");
        	req.getRequestDispatcher("main.jsp").forward(req, resp);
		}
	}
}
