package com.Revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.dao.UserDAOImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAOImpl uDAO = new UserDAOImpl();
		String action = request.getParameter("btn");
		String n1 = request.getParameter("uName");
		String n2 = request.getParameter("uPass");
		String validUser = "";
		HttpSession session=request.getSession(); 
		

		// perform log in logic
		if ("Log In".equals(action))
			validUser = uDAO.logIn(n1, n2);
		else
			validUser = uDAO.createUser(n1, n2);
		//check to see if combination was accepted
		if (validUser != "") {
			session.setAttribute("uName", validUser);
			if (validUser.equals("master"))
				session.setAttribute("isAdmin", "true");
			else
				session.setAttribute("isAdmin", "false");
			request.getRequestDispatcher("showAccts").forward(request, response);

		} 
		//incorrect combination
		else {
			request.setAttribute("errorMessage", "Username and Password were not accepted.");
			request.getRequestDispatcher("BankHome.jsp").forward(request, response);
		}
	}

}
