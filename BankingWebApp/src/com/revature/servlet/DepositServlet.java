package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.AwesomeBankDaoImple;
import com.revature.domain.*;

public class DepositServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest hreq, HttpServletResponse hres)
			throws ServletException,IOException{
		
		
	}
	
	
	protected void doPost(HttpServletRequest hreq, HttpServletResponse hres)
			throws ServletException,IOException{
		
		AwesomeBankDaoImple dao = new AwesomeBankDaoImple();
		
		

		
		
	}

}