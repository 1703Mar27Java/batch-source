package com.revature.servlets;

//implemented. Refine

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserRolesDaoImpl;
import com.revature.dao.UsersDaoImpl;
import com.revature.dao.UsersDaoImpl;
import com.revature.domain.User;
import com.revature.domain.UserRoles;
import com.revature.util.ConnectionUtil;

/**
 * Servlet implementation class CreateEmp
 */
public class CreateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateEmp() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.sendRedirect("createEmp.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empName = request.getParameter("empName");
		String empPW = request.getParameter("empPW");
		
		//also should check to see if username and/or password are already taken
		if (empName.equals("") || empPW.equals("")){
			response.sendRedirect("createEmp.jsp");
		}
		
		else{
			Connection con = null;
			try {
				con = ConnectionUtil.getConnection();
				System.out.println(con.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
					
			//test connection
			if (con != null){
				
				PrintWriter out = response.getWriter();
				out.println("Connected");
				
				//your code
				//user role will be created automatically for each user
				//start by making a user role
				/*UserRoles userRole = new UserRoles("Employee");
				UserRolesDaoImpl userRoleDao = new UserRolesDaoImpl();
				userRoleDao.newUserRole(userRole);*/
				
				//this is necessary for getting the most recent urID. There has got to be a quicker way to do this
				//int urID = userRoleDao.getCurrentUserID();
				
				//make a user and userdao object
				User user = new User(empName, empPW);
				user.setUrID(2);
				UsersDaoImpl userDao = new UsersDaoImpl();
				userDao.createEmp(user);
				
				int userID = user.getUserID();
				
				out.println(userDao.retrieveUserByLoginInfo(empName, empPW));
				
				HttpSession session = request.getSession(); 
	            session.setAttribute("empUID", Integer.toString(userID));
	            session.setAttribute("empUN", empName);
	            session.setAttribute("empPW", empPW);
	            
	            out.println(user.getPassword());
				
				//close connection
			    try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			    
			    response.sendRedirect("dashboard.jsp");
			}
			
		}
	}

}
