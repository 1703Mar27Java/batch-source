package com.revature.masterServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.BankUserUtil;


public class SuperUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SuperUserUpdate() {
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
			int uID = Integer.parseInt(req.getParameter("u_u_id"));
			String uName = req.getParameter("u_u_name");
			String uPass = req.getParameter("u_u_pass");
			String uFirst = req.getParameter("u_u_first");
			String uLast = req.getParameter("u_u_last");
			
			if(BankUserUtil.updateBankUserHelper(uID, uName, uPass, uFirst, uLast))
			{
				//send to confirmation page
				resp.sendRedirect("superConfirmation.html");
			}
			
			else
			{
				//send to error page
				resp.sendRedirect("superUpdateError.html");
			}	
		}
	}
}
