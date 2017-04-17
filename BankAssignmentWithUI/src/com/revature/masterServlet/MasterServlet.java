package com.revature.masterServlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.BankUser;
import com.revature.util.BankUserUtil;


public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MasterServlet() 
    {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(true);
		String uName = req.getParameter("u_name");
		String uPass = req.getParameter("u_pass");


		
		if(BankUserUtil.isSuperUser(uName, uPass))
		{
			session.setAttribute("superLogIn", "true");
			resp.sendRedirect("superUserHome.jsp");
			
		}
		
		else if(BankUserUtil.userCredCheck(uName, uPass))
		{
			BankUser user = new BankUser();
			user = BankUserUtil.getBankUserHelper(uName);
			session.setAttribute("loggedIn", "true");
			session.setAttribute("uID", user.getUserID());
			resp.sendRedirect("home.jsp");
		}
		
		else
		{
			resp.sendRedirect("loginFailed.html");
		}
			
	}

}
