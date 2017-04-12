package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		//System.out.println("did get");
		//writing directly to response body
		PrintWriter out = resp.getWriter();
		out.println("<p>did the get</p>");
		out.println("<a href=\"HelloWorld.html\">go home</>");
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		int result = Integer.parseInt(n1)+Integer.parseInt(n2);
		out.println("<p>sum of two numbers: "+result+"</p>");
		
	}
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		//System.out.println("did post");
		PrintWriter out = resp.getWriter();
		out.println("<p>did the post</p>");
		out.println("<a href=\"HelloWorld.html\">go home</>");
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		int result = Integer.parseInt(n1)+Integer.parseInt(n2);
		out.println("<p>sum of two numbers: "+result+"</p>");
	}

}
