package com.Revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.Revature.dao.UserDAOImpl;

/**
 * Servlet implementation class AddFunds
 */
@WebServlet("/AddFunds")
public class AddFunds extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddFunds() {
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
			int bid = Integer.parseInt(request.getParameter("bid"));
			double money = Double.parseDouble(request.getParameter("money"));
			uDAO.addFunds(bid, money);
			request.getRequestDispatcher("showAccts").forward(request, response);
		} catch (NumberFormatException e) {
			request.setAttribute("errorMessage", "BankID in must be numeric.");
			request.getRequestDispatcher("AddFunds.jsp").forward(request, response);
		}
	}

}
