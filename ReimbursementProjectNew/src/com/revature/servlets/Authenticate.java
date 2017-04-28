package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.UserBackBean;
import com.revature.domain.UserFrontBean;
import com.revature.util.UserDAOUtil;


public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession sesh = request.getSession();
		String username = request.getParameter("u_name");
		String password = request.getParameter("u_pass");

		
		if(UserDAOUtil.authenticateUser(username, password))
		{
			UserBackBean backUser = UserDAOUtil.getUserHelper(username);
			
			if(backUser.getuRole() == 1)
			{
				sesh.setAttribute("uID", backUser.getId());
				sesh.setAttribute("logged", "in");
				response.sendRedirect("employeeHome.jsp");
			}
			
			else if(backUser.getuRole() == 2)
			{
				sesh.setAttribute("uID", backUser.getId());
				sesh.setAttribute("logged", "in");
				response.sendRedirect("managerHome.jsp");
			}
			
			else
			{
				sesh.setAttribute("uID", backUser.getId());
				sesh.setAttribute("userRoleError", "true");
		        request.getRequestDispatcher("frontPage.jsp").forward(request,response);    
			}
		}
		
		else
		{
			sesh.setAttribute("foginRailed", "true");
	        request.getRequestDispatcher("frontPage.jsp").forward(request,response);    
		}
	}
}
