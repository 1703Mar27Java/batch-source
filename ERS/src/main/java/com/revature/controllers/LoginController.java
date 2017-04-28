package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.User;
import com.revature.database.DataFacadeImple;


public class LoginController {
	
	protected void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("ar you comming ehre");
	    String username = req.getParameter("username");  
	    System.out.println(username);
	    String password = req.getParameter("password"); 
	    DataFacadeImple df = new DataFacadeImple();
	    
	    User user = df.getUser(username);
	    
	    System.out.println(user.getUserID());
	   
	    if(user.getUserName() != null){
		    Boolean verify = df.authenticate(user, password);
		    HttpSession session = req.getSession();
		    System.out.println("ar you comming if");
		    if(verify){ 
		    	session.setAttribute("logged_user", "true");
		    	session.setAttribute("userObj", user);
		    	session.setAttribute("username", user.getUserName());
		    	session.setAttribute("firstName", user.getFirstName());
			    session.setAttribute("userRole", user.getRole().getUserRole());
			    session.setAttribute("userId", user.getUserID()+1);
		    	
			    System.out.println(session.getAttribute("username"));
			    System.out.println(session.getAttribute("firstName"));
			    System.out.println(session.getAttribute("userRole"));
			    System.out.println(session.getAttribute("userId"));
			  
			    
			    if(session.getAttribute("userRole").equals("MANAGER")){ 
			    	resp.sendRedirect("managerHome.do");
			    }else{
			    	resp.sendRedirect("employeeHome.do");
			    }	
			}  
			else{  
		    	
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
			} 
	    }else{
	    	
	    	req.getRequestDispatcher("/login.jsp").forward(req, resp);
	    }	
	    

	    try {
			df.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
				
		if (session != null) {
		    session.invalidate();
		}
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	

}
