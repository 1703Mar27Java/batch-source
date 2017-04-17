package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.*;

public class LogingServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest hreq, HttpServletResponse hres)
			throws ServletException,IOException{
		
		
	}
	
	
	protected void doPost(HttpServletRequest hreq, HttpServletResponse hres)
			throws ServletException,IOException{
		
		
		AwesomeBankDaoImple dao = new AwesomeBankDaoImple();
		String btn = hreq.getParameter("btn");
		String s1 = hreq.getParameter("userid");
		String s2 = hreq.getParameter("pass");
		HttpSession session = hreq.getSession();
		String user =null;
		
		
		
		if("Log In".equals(btn))
		{
			user = dao.logIn(s1, s2);
			
		}
		
		if(user !=""){
			session.setAttribute("uName", user);
			hreq.getRequestDispatcher("userAccount.jsp").forward(hreq, hres);
		}
		else
		{
			hreq.setAttribute("errorMessage", "Incorrect Login Info");
			hreq.getRequestDispatcher("login.jsp").forward(hreq, hres);
		}
		
		/*PrintWriter out = hres.getWriter();
		String s1 = hreq.getParameter("userid");
		String s2 = hreq.getParameter("pass");
		String pass = "hello";
		String username = "world";
		if(username.equals(s1) && pass.equals(s2))
		{
			out.println("<p>Welcome</p>");
			out.println("<a href=\"userAccount.jsp\">go home</a>");
		}
		else
		{
			out.println("<p>Username and password dont match</p>");
			out.println("<a href=\"HelloWorld.html\">go home</a>");
		}*/
	}
	
	

}
