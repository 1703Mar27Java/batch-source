package com.revature.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.BankAccount;
import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.sendRedirect("signup.jsp");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Create user");
		
		String userName = request.getParameter("un");
		String password = request.getParameter("pw");
		
		//also should check to see if username and/or password are already taken
		if (userName.equals("") || userName == null){
			response.sendRedirect("signup.jsp");
		}
		if ((password.equals("") && password.length() != 6) || password == null){
			response.sendRedirect("signup.jsp");
		}
		else{
			//now we can allow for the creation of a user
			
			//establish connection
			Connection con = null;
			try {
				con = ConnectionUtil.getConnection();
				System.out.println(con.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (con != null){
				out.println("connected again");
				
				//make a user and userdao object
				User user = new User(userName, password);
				UserDaoImpl userDao = new UserDaoImpl();
				userDao.createUser(user);
				
				int userID = user.getUserID();
				
				 HttpSession session = request.getSession(); 
	             session.setAttribute("userId", Integer.toString(userID));
	             session.setAttribute("userName", userName);
	             session.setAttribute("password", password);

				
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				request.getRequestDispatcher("mainPage.jsp").forward(request, response); 
				System.out.println("forwarded");
			}
			else{
				response.sendRedirect("signup.jsp");
			}
		}
	}

}
