package com.ers.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.LoginDAOImpl;
import com.ers.domain.Login;
import com.ers.util.ERSUtil;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this is a direct connection to the database itself
	try{
		 ERSUtil log = new ERSUtil();
		  System.out.println("Connected to dabatabase: "+ log);
		
			 LoginDAOImpl dao = new LoginDAOImpl();
			 int ur = Integer.parseInt(request.getParameter("ur"));
			 String r = request.getParameter("role");
			
			 dao.createEmpUser(new Login(ur,r));
			 
			 response.sendRedirect("Login.jsp"); 
			 
			
	
		//	PrintWriter out = response.getWriter();
		//	out.print("Your request has been processed.");
			//The response object is a JSP implicit object that takes the response
			//of the user sending the request and redirects them to a different page (returningUser.jsp).
			
			
			/*To do a forward, you would use the RequestDispatcher:
			 * RequestDispatcher rd = request.getRequestDispatcher("name of page");
			 * rd.forward(request, response);
			 * */
			
			//printwriter prints the response back out to the page
		//	PrintWriter out = response.getWriter();
	/*		for(User_Logon b:dao.retrieveAllUser_Logons()){
				out.println("<p>"+b.toString()+"</p>");
			}*/
		
	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	
		
		
	}

}
