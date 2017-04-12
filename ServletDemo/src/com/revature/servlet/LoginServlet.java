package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
PrintWriter out=resp.getWriter();
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		if(username.equals("username") && password.equals("password")){
			out.write("You  have successfully logged in");
			System.out.println("you have successfully loggged in");
		}
		
		else{
			out.write("Error: incorrect username or password");
			System.out.println("you are a failure at logging in");
		
		}
	}

}
