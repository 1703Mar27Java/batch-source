package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.UserDAOImpl;

/**
 * Servlet implementation class UpdatePw
 */
@WebServlet("/UpdatePw")
public class UpdatePw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePw() {
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
		String user = request.getParameter("user");
		String pw1 = request.getParameter("pw1");
		String pw2 = request.getParameter("pw2");
		UserDAOImpl uDAO = new UserDAOImpl();
		boolean success=false;
		if (pw1.equals(pw2))
			success = uDAO.updatePw(user, pw1);
		else
			success=false;
		String str = String.valueOf(success);
		
		response.getWriter().write(str);
	}

}
