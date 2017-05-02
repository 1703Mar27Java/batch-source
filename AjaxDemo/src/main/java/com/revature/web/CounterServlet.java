package com.revature.web;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int counter = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int et =Integer.parseInt(req.getParameter("ElapsedTime"));
		
		resp.setContentType("application/json");
		if(et > 0){
			counter = new Random().nextInt() + et;
			//counter = counter/100000; UNCOMMENT FOR RANDOMIZATION STEP TWO!
		}
		resp.getWriter().write("{\"counter\" : " + counter +"}");
		
	}
	
	

}
