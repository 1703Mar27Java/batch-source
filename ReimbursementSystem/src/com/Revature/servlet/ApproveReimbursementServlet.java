package com.Revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.dao.ReimbursementDAOimpl;
import com.Revature.domain.Reimbursement;
import com.Revature.domain.User;

public class ApproveReimbursementServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Integer rid = Integer.parseInt(req.getParameter("rid"));
		HttpSession session = req.getSession();
		ReimbursementDAOimpl reimbDAO = new ReimbursementDAOimpl();
		Reimbursement reimb = reimbDAO.byId(rid);
		User user = (User) session.getAttribute("User");
		System.out.println("approve user: "+user.getFirstname()+", reimb: "+reimb.getId());
		reimbDAO.approveReimb(reimb.getId(), user.getUserID());
		resp.sendRedirect("homepage.jsp");
	}
}
