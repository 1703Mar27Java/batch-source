package com.Revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.beans.TBean;
import com.Revature.dao.UserDAOImpl;

/**
 * Servlet implementation class ShowTrans
 */
@WebServlet("/ShowTrans")
public class ShowTrans extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowTrans() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAOImpl uDAO = new UserDAOImpl();
		HttpSession session = request.getSession();
		String uName = (String) session.getAttribute("uName");
		TBean b;
		if(session.getAttribute("isAdmin")!=null && session.getAttribute("isAdmin").equals("true"))
			b=new TBean(uDAO.fetchTransAdmin());
		else
			b = new TBean(uDAO.fetchTrans(uName));
		request.setAttribute("tList", b);
		request.getRequestDispatcher("ViewTransactions.jsp").forward(request, response);
	}

}
