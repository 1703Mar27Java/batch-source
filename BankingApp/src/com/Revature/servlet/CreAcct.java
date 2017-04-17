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
 * Servlet implementation class CreAcct
 */
@WebServlet("/CreAcct")
public class CreAcct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreAcct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String uName;
		if(session.getAttribute("isAdmin")!=null && session.getAttribute("isAdmin").equals("true"))
			uName=request.getParameter("adminUName");
		else
			uName= (String) session.getAttribute("uName");
		UserDAOImpl uDAO = new UserDAOImpl();
		double bal=0;
		try{	
			
			bal =  Double.parseDouble(request.getParameter("bal"));
			String acctName =  request.getParameter("acctName");
			uDAO.createAcct(uName,acctName,bal);
			request.getRequestDispatcher("showAccts").forward(request, response);
		}catch(NumberFormatException e){
			request.setAttribute("errorMessage", "Money in must be numeric.");
			request.getRequestDispatcher("CreateAcct.jsp").forward(request, response);
		}
		
	}

}
