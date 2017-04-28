package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bean.ERS_REIMBURSEMENTS;

@SuppressWarnings("serial")
public class EmployeePendingServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			List<ERS_REIMBURSEMENTS> reimbursements = (List<ERS_REIMBURSEMENTS>) session.getAttribute("reimbursements");
			
	        int uid = Integer.parseInt(req.getParameter("uid"));
	        
	        List<ERS_REIMBURSEMENTS> filtered = new ArrayList<>();
	        for (ERS_REIMBURSEMENTS i : reimbursements) {
	        	if (i.getRS_STATUS() == 1 && i.getU_ID_AUTHOR() == uid) {
	        		filtered.add(i);
	        	}
	        }
        	session.setAttribute("filtered", filtered);
	        
        	resp.sendRedirect("epending.jsp"); 
        } catch (Exception e) {
		}
	}
}
