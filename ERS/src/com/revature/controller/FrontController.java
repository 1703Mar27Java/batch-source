package com.revature.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private enum pages {
		LOGIN,
		EMPLOYEE
		
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String action = request.getAttribute("target").toString();
		action=action.toUpperCase().replaceAll("\\s+","");
		System.out.println(action);
		String page = "";
		request.setAttribute("loc", action);
		pages locPage= pages.valueOf(action);
		switch (locPage) {
		case LOGIN:
			page = "/login";
			break;
		case EMPLOYEE:
			page = "/employee.jsp";
			break;
		
		default:
			page = "/404.jsp";
		}
		dispatch(request, response, page);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page)
			throws javax.servlet.ServletException, java.io.IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
}
