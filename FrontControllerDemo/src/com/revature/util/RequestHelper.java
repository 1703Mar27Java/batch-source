package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.CocoaDAO;
import com.revature.dao.CocoaDAOImpl;

public class RequestHelper {

	private CocoaDAO dao;
	public String process(HttpServletRequest req,HttpServletResponse resp){
		System.out.println("Request helper process was called"+ req.getRequestURI());
		dao=new CocoaDAOImpl();
		
		switch(req.getRequestURI()){
		case "/FrontController/home":
			return "home.html";
			default: return "404.html";
		}
	
	}
	
}
