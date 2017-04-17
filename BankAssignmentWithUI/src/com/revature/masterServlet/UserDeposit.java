package com.revature.masterServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.util.BankAccountUtil;


public class UserDeposit extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       

    public UserDeposit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
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
				int acctID = Integer.parseInt(req.getParameter("d_a_id"));
				int amount = Integer.parseInt(req.getParameter("d_a_amt"));	
				if(BankAccountUtil.depositHelper(acctID, amount))
				{
					resp.sendRedirect("userConfirmation.html");
					
				}
				else
				{
					resp.sendRedirect("userDepositError.html");
				}
			}
			catch(NumberFormatException e)
			{
				resp.sendRedirect("userDepositError.html");
			}
		}
		
				
	}
}
