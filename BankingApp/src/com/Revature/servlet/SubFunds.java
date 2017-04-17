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
 * Servlet implementation class SubFunds
 */
@WebServlet("/SubFunds")
public class SubFunds extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubFunds() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAOImpl uDAO = new UserDAOImpl();
		try {
			HttpSession session = request.getSession();
			int bid = Integer.parseInt(request.getParameter("bid"));
			double money = Double.parseDouble(request.getParameter("money"));
			//confirm current user owns the account
			String owner=uDAO.getUserOfBankAcct(bid);
			if (session.getAttribute("isAdmin").equals("true") || owner.equals(session.getAttribute("uName"))){
				uDAO.subFunds(bid, money);
				request.getRequestDispatcher("showAccts").forward(request, response);
			}
			else {
				request.setAttribute("errorMessage", "BankID must be yours!");
				request.getRequestDispatcher("SubFunds.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			request.setAttribute("errorMessage", "BankID in must be numeric.");
			request.getRequestDispatcher("SubFunds.jsp").forward(request, response);
		}
	}

}
