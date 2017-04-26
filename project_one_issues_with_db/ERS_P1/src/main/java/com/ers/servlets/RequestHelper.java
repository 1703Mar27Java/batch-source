package com.ers.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	
		public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			System.out.println("Request helper process was called" + req.getRequestURI());
			switch (req.getParameter("login")) {

			case "emp":
				return "/error.jsp";
			case "mgr":
				return "/MgrServlet";
			default:
				return "404.html";
			}
		}

}
