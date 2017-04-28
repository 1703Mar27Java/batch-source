package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.ReimbursementStatusDAOImpl;
import com.ers.domain.ReimbursementStatus;
import com.ers.util.ERSUtil;

public class ReimburseStatusServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		try{
			 ERSUtil r = new ERSUtil();
			  System.out.println("Connected to dabatabase: "+ r);
			
				 ReimbursementStatusDAOImpl dao = new ReimbursementStatusDAOImpl();
			//	 int rs_id = Integer.parseInt(request.getParameter(""));
			//	 String s = request.getParameter("status"));
			
			//	 dao.enterStatus(new ReimbursementStatus(0,s));
				 
			//	 response.sendRedirect("info.jsp"); 
				 
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	}
}
