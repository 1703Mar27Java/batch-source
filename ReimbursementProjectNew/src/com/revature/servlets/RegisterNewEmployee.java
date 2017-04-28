package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.UserFrontBean;
import com.revature.util.UserDAOUtil;

public class RegisterNewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession sesh = request.getSession();

		UserFrontBean front = new UserFrontBean();
		String userN = request.getParameter("rUname");
		String password = request.getParameter("rPword");
		String firstN = request.getParameter("rFName");
		String lastN = request.getParameter("rLName");
		String email = request.getParameter("rEmail");

	
		front.setFirstName(firstN);
		front.setLastName(lastN);
		front.setUsername(userN);
		front.setEmail(email);
		front.setPassword(password);
		System.out.println(front.toString());
		
		System.out.println(front.toString());
		
		PrintWriter out = response.getWriter();
		if(UserDAOUtil.createUserHelper(front))
		{
			System.out.println("yay");
			out.print("Employee Registered");
		}
		else
		{
			System.out.println("boo");
			out.print("Something went terribly wrong.  Contact administrator");
		}
		


	}

}