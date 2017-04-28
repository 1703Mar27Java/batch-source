package com.revature.servlet;

import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.revature.bean.*;
import com.revature.dao.*;

@SuppressWarnings("serial")
public class ResolveServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			ERS_REIMBURSEMENTSDAO rdao = new ERS_REIMBURSEMENTSDAOImpl();
			ERS_USERS currentUser = (ERS_USERS) session.getAttribute("currentUser");

	        int status = Integer.parseInt(req.getParameter("status"));
	        int crid = Integer.parseInt(req.getParameter("crid"));
	        
	        rdao.resolve(crid, status, currentUser.getU_ID());
	        List<ERS_REIMBURSEMENTS> reimbursements = rdao.loadAll();
        	session.setAttribute("reimbursements", reimbursements);
	        
        	resp.sendRedirect("main.jsp"); 
        } catch (Exception e) {
		}
	}
}
