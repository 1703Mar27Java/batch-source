package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserRolesDaoImpl;
import com.revature.dao.UsersDaoImpl;
import com.revature.domain.User;
import com.revature.domain.UserRoles;
import com.revature.util.ConnectionUtil;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			System.out.println(con.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		            
		/*forward*/
		if (con != null){
			
			PrintWriter out = response.getWriter();;
			out.println("Connected");
			
			String userName = request.getParameter("un");
			String password = request.getParameter("pw");
	                
	        //try to incorporate dao files into login
			UsersDaoImpl userDao = new UsersDaoImpl();
		            
            User user = userDao.retrieveUserByLoginInfo(userName, password);
		            
            //close connection
		     try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}   
		                
		     //see if username and password are right
		    if (user != null){
		    	 HttpSession session = request.getSession();
		    	 int roleID = user.getUrID();
	             session.setAttribute("userName", user.getUserName());
	             session.setAttribute("password", user.getPassword());
	             session.setAttribute("firstName", user.getFirstName());
	             session.setAttribute("lastName", user.getLastName());
	             session.setAttribute("email", user.getEmailAddress());
	             session.setAttribute("id", new Integer(user.getUserID()));
	             
	           //find the user role accociated with the user role id
	 			UserRolesDaoImpl userRoleDao = new UserRolesDaoImpl();       
	            UserRoles userRole = userRoleDao.retrieveUserRoleByID(roleID);
	            
	         
	            //if user role it is found
	            if (userRole != null){
	            	session.setAttribute("userRole", userRole.getUrRole());
	            	
	            	//if user is a manager, load current requests
	            }
	             
	            response.sendRedirect("dashboard.jsp");
		    }
		    else{
		    	response.sendRedirect("index.jsp");
		    }	
		}
	}
}
