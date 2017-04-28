package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.UserDAOImpl;
import com.revature.util.mailer;

/**
 * Servlet implementation class MakeUser
 */
@WebServlet("/MakeUser")
public class MakeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MakeUser() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String e = request.getParameter("e");
		String f = request.getParameter("f");
		String l = request.getParameter("l");
		String u = request.getParameter("u");
		String t = request.getParameter("t");
		UserDAOImpl uDAO = new UserDAOImpl();
		boolean accepted = uDAO.makeUser(e, f, l, u, t);
		
		String str = String.valueOf(accepted);
		if(accepted){
			mailer.mail( e, 
					"Congratulations, you have been added to Revature's Employee Reimbursement System. "
					+ "Please log in with the password 'password' to review your data and update your password.");
		}
		
		response.getWriter().write(str);
	}

}
