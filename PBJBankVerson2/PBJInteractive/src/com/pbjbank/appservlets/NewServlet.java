package com.pbjbank.appservlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.pbjbank.dao.BankUserDAOImpl;
import com.pbjbank.domain.User_Logon;
import com.pbjbank.util.ConnectionUtil;


public class NewServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	//	response.setContentType("text/html");
	//	PrintWriter out = response.getWriter();
	
		try {
			ConnectionUtil c = new ConnectionUtil();
			System.out.println("Database connected " + c);
			BankUserDAOImpl dao = new BankUserDAOImpl();
			String username = request.getParameter("username");
			String password = request.getParameter("password");	
			dao.createNewUserPS(new User_Logon(0,username,password));	
			response.sendRedirect("newUser.jsp");
		//	PrintWriter out = response.getWriter();
		//	out.println("You now have a new account!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	//	RequestDispatcher rd = request.getRequestDispatcher("");
	//	rd.forward(request, response);
		 
		
		//printwriter prints the response back out to the page
	//	PrintWriter out = response.getWriter();
		
		
		//try adding a direct connection (forward) here
		
		
		
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	//	response.setContentType("text/html");
	//	PrintWriter out = response.getWriter();
		
		try{	
				ConnectionUtil c = new ConnectionUtil();
				System.out.println("database connected"+c);
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				BankUserDAOImpl dao = new BankUserDAOImpl();
				dao.createNewUserPS(new User_Logon(0,username,password));	
				//out.println("You now have a new account!");
				response.sendRedirect("newUser.jsp");
			}catch(Exception e){
				e.printStackTrace();
			}
				
	}
	
	
}
