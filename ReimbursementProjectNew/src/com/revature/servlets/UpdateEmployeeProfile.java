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

public class UpdateEmployeeProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession sesh = request.getSession();

		UserFrontBean front = new UserFrontBean();
		String firstN = request.getParameter("firstName");
		String lastN = request.getParameter("lastName");
		String userN = request.getParameter("userName");
		String email = request.getParameter("email");
		int resetPW = Integer.parseInt(request.getParameter("pwReset"));
		int userID = (int) sesh.getAttribute("uID");
	
		
		front.setFirstName(firstN);
		front.setLastName(lastN);
		front.setUsername(userN);
		front.setEmail(email);
		front.setId(userID);
		
		boolean reset = false;
	
		if(resetPW == 1)
		{
			reset = true;
		}
		
		
		System.out.println(front.toString());
		
		PrintWriter out = response.getWriter();
		if(UserDAOUtil.updateUserHelper(front, reset))
		{
			System.out.println("yay");
			out.print("Profile updated");
		}
		else
		{
			System.out.println("boo");
			out.print("Something went terribly wrong.  Contact administrator");
		}
		


	}

}