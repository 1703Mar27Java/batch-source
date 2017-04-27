package com.Revature.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.Revature.dao.ReimbursementDAOimpl;
import com.Revature.domain.Reimbursement;
import com.Revature.domain.User;

public class CreateReimbursementServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Integer amount = Integer.parseInt(req.getParameter("amount"));
		String desc = req.getParameter("description");
		Integer rtype = Integer.parseInt(req.getParameter("reimbType"));
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		int uid = user.getUserID();
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
		Reimbursement reimb = new Reimbursement();
		ReimbursementDAOimpl reimbDAO = new ReimbursementDAOimpl();
		reimb.setAmount(amount);
		reimb.setDescription(desc);
		reimb.setTypeID(rtype);
		reimb.setSubmitterID(uid);
		reimb.setTimestamp(timestamp);
		reimbDAO.createReimbursement(reimb);
		//List<Reimbursement> reimbs = new ArrayList<Reimbursement>();
		
		resp.sendRedirect("homepage.jsp");
	}
}
