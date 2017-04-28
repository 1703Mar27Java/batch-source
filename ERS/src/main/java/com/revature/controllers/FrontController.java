package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doWork(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doWork(req, resp);
	}
	
	protected void doWork(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();

		switch(requestURI){
		case "/ERS/login.do" : new LoginController().doLogin(req, resp);
			break;
	    case "/ERS/managerHome.do" : new ManagerController().goToManagerHomePage(req,resp);
	    	break;
	    case "/ERS/employeeHome.do" : new EmployeeController().goToEmployeeHomePage(req,resp);
	    	break;
	    case "/ERS/statusButton.do" : new ManagerController().statusPressed(req, resp);
	    	break;
	    case "/ERS/addReimbursement.do" : new EmployeeController().addNewReimbursement(req, resp);
	    	break;
	    case "/ERS/filterReimbursement.do" : new ManagerController().filterReimbursement(req,resp);
	    	break;
	    case "/ERS/logout.do" : new LoginController().doLogout(req, resp);
	    	break;
		}
	}

}
