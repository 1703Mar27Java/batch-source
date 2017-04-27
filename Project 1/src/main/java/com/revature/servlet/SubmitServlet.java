package com.revature.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.bean.*;
import com.revature.dao.*;

@SuppressWarnings("serial")
public class SubmitServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			ERS_REIMBURSEMENTSDAO rdao = new ERS_REIMBURSEMENTSDAOImpl();
			ERS_USERS currentUser = (ERS_USERS) session.getAttribute("currentUser");

	        double amount = Double.parseDouble(req.getParameter("amount"));
	        String description = req.getParameter("description");
	        String type = req.getParameter("type");
	        
	        rdao.submit(amount, description, currentUser.getU_ID(), type);
	        
        	resp.sendRedirect("main.jsp"); 
        } catch (Exception e) {
		}
	}
}
