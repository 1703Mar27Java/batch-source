package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.Calendar;

import com.revature.domain.ReimbursementBackBean;
import com.revature.util.ReimDAOUtil;

public class ManageReims extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession sesh = request.getSession();
		Date currTime = new Date(Calendar.getInstance().getTime().getTime());

		ReimbursementBackBean back = new ReimbursementBackBean();
		String status = request.getParameter("subReqType");
		int reimID = Integer.parseInt(request.getParameter("subReqDesc"));
		int manID = (int)sesh.getAttribute("uID");

		back = ReimDAOUtil.getReim(reimID);
		back.setUserResolverID(manID);
		back.setResolved(currTime);
		
		System.out.println("made it here");
		if(status.equals("approve"))
		{
			back.setStatus(3);

		}
		else if(status.equals("decline"))
		{
			back.setStatus(4);
		}
		
		PrintWriter out = response.getWriter();
		if(ReimDAOUtil.updateReimHelper(back))
		{
			System.out.println("yay");
			out.print("Reimbursement successfully updated");
		}
		else
		{
			System.out.println("boo");
			out.print("Something went horribly wrong.  Contact your instructor.");
		}
	}

}
