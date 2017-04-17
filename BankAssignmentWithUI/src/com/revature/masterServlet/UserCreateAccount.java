package com.revature.masterServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.BankAccountUtil;


public class UserCreateAccount extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public UserCreateAccount() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession sesh = req.getSession();
		if(sesh.getAttribute("loggedIn").equals("false"))
		{
			resp.sendRedirect("login.html");
		}
		
		else
		{
			try
			{
				int userID = (Integer)sesh.getAttribute("uID");
				String acctName = req.getParameter("c_a_acctName");
				int initBal = Integer.parseInt(req.getParameter("c_a_amt"));
				
				if(BankAccountUtil.createAcctNameValid(userID, acctName))
				{
					if(BankAccountUtil.createAccountHelper(userID, acctName, initBal))
					{
						resp.sendRedirect("userConfirmation.html");
					}
				}
				else
				{
					resp.sendRedirect("userCreateError.html");
				}
				
			}
			catch(NumberFormatException e)
			{
				resp.sendRedirect("userCreateError.html");
			}
		}		
	}
}
