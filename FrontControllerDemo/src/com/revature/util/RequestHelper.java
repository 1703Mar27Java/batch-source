package com.revature.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

import com.revature.beans.Cocoa;
import com.revature.dao.CocoaDAO;
import com.revature.dao.CocoaDAOImpl;

public class RequestHelper {

	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Request helper process was called" + req.getRequestURI());
		switch (req.getParameter("location")) {

		case "cocoa":
			return "/CocoaServlet";
		case "coffee":
			return "/CoffeeServlet";
		default:
			return "404.html";
		}
	}

}
