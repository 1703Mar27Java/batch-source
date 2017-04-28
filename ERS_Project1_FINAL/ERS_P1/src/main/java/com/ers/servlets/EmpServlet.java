package com.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.dao.EmployeeDAOImpl;
import com.ers.util.ERSUtil;
import com.ers.domain.Employee;


public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this is a direct connection to the database itself
	try{
		 ERSUtil n = new ERSUtil();
		  System.out.println("Connected to database: "+ n);
			
			 EmployeeDAOImpl dao = new EmployeeDAOImpl();
			 int id = Integer.parseInt(request.getParameter("id"));
			 String un = request.getParameter("username");
			 String pw = request.getParameter("password");
			 String fn = request.getParameter("first");
			 String ln = request.getParameter("last");
			 String em = request.getParameter("email");
			 int urid = Integer.parseInt(request.getParameter("urid"));
			 dao.createEmpAcct(new Employee(id,un, pw,fn, ln, em,urid));
			
		/*	PrintWriter out = response.getWriter();
			out.print("Your request has been processed.");*/
			//The response object is a JSP implicit object that takes the response
			//of the user sending the request and redirects them to a different page (returningUser.jsp).
			
			 
			 
			 response.sendRedirect("info.jsp"); 
			
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
