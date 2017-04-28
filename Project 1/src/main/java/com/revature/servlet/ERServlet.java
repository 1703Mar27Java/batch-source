package com.revature.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.bean.*;

@SuppressWarnings("serial")
public class ERServlet extends HttpServlet{
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			ERS_USERS currentUser = (ERS_USERS) session.getAttribute("currentUser");
			List<ERS_REIMBURSEMENTS> reimbursements = (List<ERS_REIMBURSEMENTS>) session.getAttribute("reimbursements");
			
	        int status = Integer.parseInt(req.getParameter("option"));
	        
	        List<ERS_REIMBURSEMENTS> filtered = new ArrayList<>();
	        for (ERS_REIMBURSEMENTS i : reimbursements) {
	        	if (i.getU_ID_AUTHOR() == currentUser.getU_ID() && i.getRS_STATUS() == status) {
	        		filtered.add(i);
	        	}
	        }
        	session.setAttribute("filtered", filtered);
	        
        	resp.sendRedirect("reimbursements.jsp"); 
        } catch (Exception e) {
		}
	}
}
