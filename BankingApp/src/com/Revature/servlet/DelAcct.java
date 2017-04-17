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
 * Servlet implementation class DelAcct
 */
@WebServlet("/DelAcct")
public class DelAcct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelAcct() {
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
		int bid = 0;
		try {
			HttpSession session = request.getSession();
			bid = Integer.parseInt(request.getParameter("bid"));
			String owner = uDAO.getUserOfBankAcct(bid);
			if (session.getAttribute("isAdmin").equals("true") || owner.equals(session.getAttribute("uName"))) {
				uDAO.deleteAcct(bid);
				request.getRequestDispatcher("showAccts").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "BankID must be yours!");
				request.getRequestDispatcher("DeleteAcct.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			request.setAttribute("errorMessage", "BankID in must be numeric.");
			request.getRequestDispatcher("DeleteAcct.jsp").forward(request, response);
		}
	}

}
