package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.ReimbursementFrontBean;
import com.revature.util.ReimDAOUtil;

public class SubmitRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession sesh = request.getSession();

		ReimbursementFrontBean front = new ReimbursementFrontBean();
		String type = request.getParameter("subReqType");
		double amt = Double.parseDouble(request.getParameter("subReqAmt"));
		String desc = request.getParameter("subReqDesc");
		String rec = null;
		//String rec = request.getParameter("subReqRec");
		int userID = (int) sesh.getAttribute("uID");
		String status = "PENDING";
		
		front.setType(type);
		front.setAmount(amt);
		front.setDescription(desc);
		front.setReceipt(rec);
		front.setUserAuthorID(userID);
		front.setStatus(status);
		
		System.out.println(front.toString());
		
		System.out.println("made it");
		PrintWriter out = response.getWriter();
		if(ReimDAOUtil.createReimHelper(front))
		{
			System.out.println("yay");
			out.print("Reimbursement successfully submitted");
		}
		else
		{
			System.out.println("boo");
			out.print("Something went wrong.  Contact administrator");
		}
		


	}

}
