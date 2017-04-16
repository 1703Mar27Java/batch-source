package com.Revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.beans.Bean;
import com.Revature.dao.UserDAOImpl;

/**
 * Servlet implementation class CreateAcct
 */
@WebServlet("/CreateAcct")
public class ShowAccts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAccts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//entry point from login.java
		UserDAOImpl uDAO = new UserDAOImpl();
		HttpSession session=request.getSession(); 
		String n= (String) session.getAttribute("uName");
		
		Bean b = null;
		if(session.getAttribute("isAdmin")!=null && session.getAttribute("isAdmin").equals("true"))
			b = new Bean(uDAO.fetchAdmin());
		else 
			b = new Bean(uDAO.fetchAccts(n));
		request.setAttribute("bean", b);
		request.setAttribute("isAdmin", session.getAttribute("isAdmin"));
		request.getRequestDispatcher("control.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
