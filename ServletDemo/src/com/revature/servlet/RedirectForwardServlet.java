package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectForwardServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
	/*forward*/
	/*RequestDispatcher rd= req.getRequestDispatcher("OtherPage.html");
	rd.forward(req, resp);
	System.out.println("forwarded");*/
	
	resp.sendRedirect("OtherPage.html");
	System.out.println("redirected");
}
}
