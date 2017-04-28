package com.revature.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession sesh = req.getSession();

		String control = req.getParameter("control");
		
		boolean logged = false;;
		Enumeration<String> attrs = req.getAttributeNames();
		while(attrs.hasMoreElements())
		{
			if(attrs.nextElement().equals("logged"))
			{
				logged = true;
			}
		}
		
		
		if(logged == true)
		{
			if(req.getAttribute("logged").equals("out") || !control.equals("authenticate"))
			{
				resp.sendRedirect("frontPage.jsp");
			}
		}

		else
		{
	        req.getRequestDispatcher(control).forward(req,resp);    
		}	
	}
}
