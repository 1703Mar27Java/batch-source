package com.pbjbank.appservlets;

import java.io.IOException;
import java.io.PrintWriter;

//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pbjbank.dao.BankDAOImpl;
import com.pbjbank.domain.BankAccount;
import com.pbjbank.util.ConnectionUtil;


public class BankAccountServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		try {
			ConnectionUtil c = new ConnectionUtil();
			System.out.println("Database connected " + c);
			BankDAOImpl dao = new BankDAOImpl();
			String baName = request.getParameter("baName");
			int bal = Integer.parseInt(request.getParameter("bal"));
			dao.createBankAccountPS(new BankAccount(0,0,baName,bal));
			response.setContentType("text/html");
		//	PrintWriter out = response.getWriter();
			out.println("You now have a new account!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
