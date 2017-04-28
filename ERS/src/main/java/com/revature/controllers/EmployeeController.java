package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Reimbursements;
import com.revature.beans.User;
import com.revature.database.DataFacadeDAO;
import com.revature.database.DataFacadeImple;

public class EmployeeController {
	
	protected void goToEmployeeHomePage(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		DataFacadeDAO df = null;
		HttpSession session = req.getSession(false);

		try {
			df = new DataFacadeImple();
			User user = (User) session.getAttribute("userObj");
			List<Reimbursements> userReimb = df.getUsersReimbursements(user.getUserID());

			req.setAttribute("userReimb", userReimb);
			req.getRequestDispatcher("/employeeHome.jsp").forward(req, res);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				df.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	protected void addNewReimbursement(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
	{
		
		
		DataFacadeDAO df = null;

		HttpSession session = req.getSession(false);
		
    	session.setAttribute("reimbType", req.getParameter("type"));
    	session.setAttribute("reimbAmount", req.getParameter("amount"));
    	session.setAttribute("reimbDescription", req.getParameter("description"));

		try {
			
			df = new DataFacadeImple();
			int type = Integer.parseInt(session.getAttribute("reimbType").toString());
			
			double amount = Double.parseDouble(req.getParameter("amount"));
			
			String description = session.getAttribute("reimbDescription").toString();
			
			User user = (User) session.getAttribute("userObj");
			Reimbursements reimb =  new Reimbursements(amount, description, user, type);
			
			df.newReimbursement(reimb);
			res.sendRedirect("employeeHome.do");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				df.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
