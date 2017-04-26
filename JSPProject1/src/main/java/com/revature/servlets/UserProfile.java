package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UsersDaoImpl;
import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

import java.util.HashMap;
import java.util.Map; 

/**
 * Servlet implementation class UserProfile
 */
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//make connection and get user information
		
		response.sendRedirect("profile.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		int id = ((Integer)session.getAttribute("id")).intValue();
		String un = request.getParameter("Username");
		String fName = request.getParameter("Fname");
		String lName = request.getParameter("Lname");
		String email = request.getParameter("Email");
		
		//get connection
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			System.out.println(con.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (con != null){
			
			out.println("Connected");
			
	                
	        //try to incorporate dao files into login
			UsersDaoImpl userDao = new UsersDaoImpl();
		            
            User user = userDao.retrieveUserById(id);
            userDao.updateUser(user, un, fName, lName, email);
            
            //close connection
		     try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}   
		                
		     //see if username and password are right
		    if (user != null){
		    	//update everything
		    	 session.setAttribute("userName", user.getUserName());
	             session.setAttribute("password", user.getPassword());
	             session.setAttribute("firstName", user.getFirstName());
	             session.setAttribute("lastName", user.getLastName());
	             session.setAttribute("email", user.getEmailAddress());
	             session.setAttribute("id", new Integer(user.getUserID()));
		    }
		}
		
		String objectToReturn = "{"+un+","+fName+", "+lName+", "+email+"}";		
		out.println(objectToReturn);
		
		 //update fields after db is changed
		 /*int roleID = user.getUrID();
         session.setAttribute("userName", user.getUserName());
         session.setAttribute("password", user.getPassword());
         session.setAttribute("firstName", user.getFirstName());
         session.setAttribute("lastName", user.getLastName());
         session.setAttribute("email", user.getEmailAddress());*/
		
	}

}
