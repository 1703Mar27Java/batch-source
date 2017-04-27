package com.Revature.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.dao.ReimbursementDAOimpl;
import com.Revature.domain.SimpleReimb;
import com.Revature.domain.User;

public class ViewReimbursementServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Integer rid = Integer.parseInt(req.getParameter("rid"));
		HttpSession session = req.getSession();
		ReimbursementDAOimpl reimbDAO = new ReimbursementDAOimpl();
		session.setAttribute("reimb", reimbDAO.byId(rid));
		resp.sendRedirect("viewReimbursement.jsp");
	}
}
