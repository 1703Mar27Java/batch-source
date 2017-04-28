package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Reimbursements;
import com.revature.database.DataFacadeImple;

public class ManagerController {

	protected void goToManagerHomePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

		DataFacadeImple df = null;

		try {
			df = new DataFacadeImple();

			HttpSession session = req.getSession(false);
			List<Reimbursements> allReimb = null;

			if (session.getAttribute("filterStatus") != null) {
				int status = Integer.parseInt(session.getAttribute("filterStatus").toString());
				if (status > 0) {
					allReimb = df.getFilteredReimbursements(status);
				} else {
					allReimb = df.getAllReimbursements();
				}
			} else {
				allReimb = df.getAllReimbursements();

			}

			req.setAttribute("allReimb", allReimb);
			req.getRequestDispatcher("/managerHome.jsp").forward(req, resp);

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
	
	protected void statusPressed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

		HttpSession session = req.getSession(false);		
		
		session.setAttribute("reimbID", req.getParameter("reimbID"));

		DataFacadeImple df = null;

		try {
			df = new DataFacadeImple();

			int status = Integer.parseInt(req.getParameter("statusSelected"));
			int managerID = Integer.parseInt(session.getAttribute("userId").toString());
			int reimbID = Integer.parseInt(session.getAttribute("reimbID").toString());

			df.updateReimbursementsStatus(managerID, reimbID, status);
			 resp.sendRedirect("managerHome.do");
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
	
	protected void filterReimbursement(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		
		session.setAttribute("filterStatus", req.getParameter("filter"));

		DataFacadeImple df = null;

		try {
			df = new DataFacadeImple();

			int status = Integer.parseInt(session.getAttribute("filterStatus").toString());
	
			
			if (status > 0) {
				resp.sendRedirect("managerHome.do");
			} 
			else {
				resp.sendRedirect("managerHome.do"); 
			}
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
