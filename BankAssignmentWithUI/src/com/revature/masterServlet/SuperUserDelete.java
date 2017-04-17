package com.revature.masterServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.BankUserUtil;


public class SuperUserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession sesh = req.getSession();
		if(sesh.getAttribute("superLogIn").equals("false"))
		{
			resp.sendRedirect("login.html");
		}
		
		else
		{
			String uName = req.getParameter("d_u_name");

			
			if(BankUserUtil.deleteUserHelper(uName))
			{
				//send to confirmation page
				resp.sendRedirect("superConfirmation.html");
			}
			
			else
			{
				//send to error page
				resp.sendRedirect("superDeleteError.html");
			}	
		}	
	}
}
