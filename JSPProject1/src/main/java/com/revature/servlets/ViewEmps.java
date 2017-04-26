package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

//implemented. Now work on the UI

/**
 * Servlet implementation class ViewEmps
 */
public class ViewEmps extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ViewEmps() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			UsersDaoImpl userDao = new UsersDaoImpl();
			List<User> users = userDao.retrieveEmployees();
			
			out.println(users);
			
			HttpSession session = request.getSession(); 
			session.setAttribute("users", users);
			
			//close connection
		    try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    
		    //response.sendRedirect("dashboard.jsp");
		}
	}
}
