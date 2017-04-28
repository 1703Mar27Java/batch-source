package com.ers.servlets;

import java.io.IOException;

import javax.servlet.http.*;


public class RequestHelper {

	
		public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			System.out.println("Request helper process was called" + req.getRequestURI());
			switch (req.getParameter("role")) {

			case "employee":
				return "/Info.jsp";
			case "manager":
				return "/MgrInfo.jsp";
			default:
				return "404.html";
			}
		}

		
}
