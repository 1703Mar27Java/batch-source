package com.ers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.ReimbursementTypeDAOImpl;
import com.ers.domain.ReimbursementType;
import com.ers.util.ERSUtil;

public class ReimburseTypeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		try{
			 ERSUtil r = new ERSUtil();
			  System.out.println("Connected to dabatabase: "+ r);
			
			//	 ReimbursementTypeDAOImpl dao = new ReimbursementTypeDAOImpl();
			 
			//	int rt_id = Integer.parseInt(request.getParameter(""));
		//		String type = request.getParamter("type");
			//	 dao.enterTypeInfo(new ReimbursementType(0,type);
				 
			//	 response.sendRedirect("info.jsp"); 
				 
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	}

}
