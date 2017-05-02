package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Cocoa;
import com.revature.dao.CocoaDAO;
import com.revature.dao.CocoaDAOImpl;


public class CocoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CocoaDAO dao = new CocoaDAOImpl();
		PrintWriter out = response.getWriter();
		for(Cocoa c:dao.getBeans()){
			out.println("<p>"+c.toString()+"</p>");
		}
	}
	

}
