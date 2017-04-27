package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.RequestDAOImpl;

/**
 * Servlet implementation class AddReq
 */
@WebServlet("/AddReq")
public class AddReq extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddReq() {
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
		HttpSession session=request.getSession(); 
		
		System.out.println(session.getAttribute("uName"));
		System.out.println(request.getParameter("descr"));
		System.out.println(request.getParameter("amt"));
		System.out.println(request.getParameter("type"));
		RequestDAOImpl rDAO = new RequestDAOImpl();
		rDAO.createReq(request.getParameter("descr").toString(), 
				Double.parseDouble(request.getParameter("amt")), 
				session.getAttribute("uName").toString(), 
				request.getParameter("type").toString());
		request.getRequestDispatcher("employee.jsp").forward(request, response);
		//response.sendRedirect("/employee.jsp");
	}

}
