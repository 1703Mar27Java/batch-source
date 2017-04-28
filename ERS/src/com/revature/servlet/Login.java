package com.revature.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bean.User;
import com.revature.dao.UserDAOImpl;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String n = request.getParameter("uName");
		String p = request.getParameter("uPass");
		String v="";
		HttpSession session=request.getSession(); 
		UserDAOImpl uDAO = new UserDAOImpl();
		v = uDAO.logIn(n, p);
		
		if(v!=null && !v.equals("")){
			//good password
			session.setAttribute("uName", v);
			User u=uDAO.getUser(v);
			System.out.println("Logging in with "+u);
			request.setAttribute("uBean", u);
			if(uDAO.isMgr(v)){
				session.setAttribute("isMgr", "true");
				request.getRequestDispatcher("manager.jsp").forward(request, response);
			}
			else{
				session.setAttribute("isMgr", "false");
				request.getRequestDispatcher("employee.jsp").forward(request, response);
			}
			//request.setAttribute("target", "employee");
		}
		else { 
			//bad password
			request.setAttribute("errorMessage", "Username and Password were not accepted.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
