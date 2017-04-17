package com.revature.masterServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.BankUserUtil;



public class SuperUserCreate extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public SuperUserCreate() 
    {
        super();
    }

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
			String uName = req.getParameter("c_u_name");
			String uPass = req.getParameter("c_u_pass");
			String uFirst = req.getParameter("c_u_first");
			String uLast = req.getParameter("c_u_last");
			
			if(BankUserUtil.createUserHelper(uName, uPass, uFirst, uLast))
			{
				//send to confirmation page
				resp.sendRedirect("superConfirmation.html");
			}
			
			else
			{
				//send to error page
				resp.sendRedirect("superCreateError.html");
			}
		}
	}
}
