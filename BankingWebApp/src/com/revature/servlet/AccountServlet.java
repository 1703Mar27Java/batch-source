package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.AwesomeBankDaoImple;

public class AccountServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest hreq, HttpServletResponse hres)
			throws ServletException,IOException{
		
		
	}
	
	
	protected void doPost(HttpServletRequest hreq, HttpServletResponse hres)
			throws ServletException,IOException{
		
		AwesomeBankDaoImple dao = new AwesomeBankDaoImple();
		
		String withdrawB = hreq.getParameter("withButton");
		String depositB = hreq.getParameter("depButton");
		System.out.println(withdrawB);
		System.out.println(depositB);
		//AccID
		String accID    = hreq.getParameter("accID");
		int accIDnum = Integer.parseInt(accID);
		System.out.println(accID);
		//Withdraw Amount
		String withdraw  = hreq.getParameter("with");
		int wAmmount = Integer.parseInt(withdraw);
		//Deposit Amount
		String deposit  = hreq.getParameter("dep");
		int dAmmount = Integer.parseInt(deposit);
		
		if(withdrawB != null && depositB == null)
		{
			dao.withdraw(accIDnum, wAmmount);
			hreq.getRequestDispatcher("userAccount.jsp").forward(hreq, hres);
		}
		else if(withdrawB == null && depositB != null)
		{
			System.out.println("here error else if");
		
			hreq.getRequestDispatcher("userAccount.jsp").forward(hreq, hres);
		}
	
	}

}
