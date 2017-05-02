package com.revature.controllers;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.*;
import com.revature.dao.*;


public class CoffeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CoffeeDAO dao = new CoffeeDAOImpl();
		PrintWriter out = response.getWriter();
		for(Coffee c:dao.getBeans()){
			out.println("<p>"+c.toString()+"</p>");
		}
	}
	

}