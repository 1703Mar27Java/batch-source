package com.revature.controllers;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class Authentication implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("here");
		HttpServletRequest request = (HttpServletRequest) req;
		if (request.getSession().getAttribute("logged_user") == null) {
			req.getRequestDispatcher("/login.do").forward(req, res);
		} else {

			if (request.getSession().getAttribute("userRole").equals(2)) { 
				
				req.getRequestDispatcher("/managerHome.do").forward(req, res);

			} else if (request.getSession().getAttribute("userRole").equals(1)) {
				
				req.getRequestDispatcher("/employeeHome.do").forward(req, res);
			} else {
				
				chain.doFilter(req, res);
			}
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("in AuthFilter init");

	}

}
