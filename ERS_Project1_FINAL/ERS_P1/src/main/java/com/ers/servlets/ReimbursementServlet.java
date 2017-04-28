package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.ReimbursementsDAOImpl;
import com.ers.domain.Reimbursements;
import com.ers.util.ERSUtil;

public class ReimbursementServlet extends HttpServlet {
	
	
private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this is a direct connection to the database itself
	try{
		 ERSUtil r = new ERSUtil();
		  System.out.println("Connected to dabatabase: "+ r);
		
			 ReimbursementsDAOImpl dao = new ReimbursementsDAOImpl();
		//	 int rid = Integer.parseInt(request.getParameter(""));;
			 double amt = Double.parseDouble(request.getParameter("amt"));
			 String desc = request.getParameter("desc");
		//	 String receipt = request.getParameter("");
		//	 String timestamp = request.getParameter("");
		//	 int author = Integer.parseInt(request.getParameter(""));
		//	 int resolved = Integer.parseInt(request.getParameter(""));
		//	 int type = Integer.parseInt(request.getParameter(""));
		//	 int  status =Integer.parseInt(request.getParameter(""));
			 dao.submitReimbursements(new Reimbursements(0,amt,desc,"","0",0,0,0,0));
			 
			 response.sendRedirect("info.jsp"); 
			 
		
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	
		
		
}

}
