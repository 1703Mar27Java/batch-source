package com.revature.masterServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Logout() 
    {
        super();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession sesh = req.getSession();
		
		if(req.getParameter("logout") != null)
		{
			sesh.setAttribute("loggedIn", "false");
			sesh.setAttribute("superLogIn", "false");
			sesh.invalidate();
			resp.sendRedirect("login.html");
		}
	}

}
