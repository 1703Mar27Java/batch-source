package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MakeRequest
 */
public class MakeRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public MakeRequest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("makeRequest.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();;
		out.println("Connected");
		
		String amount = request.getParameter("amt");
		String description= request.getParameter("desc");
		String typ = request.getParameter("types"); 
		
		out.println(amount);
		out.println(description);
		out.println(typ);	
	}

}
