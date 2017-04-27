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

import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UsersDaoImpl;
import com.revature.domain.Reimbursement;
import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

/**
 * Servlet implementation class MakeRequest
 */
public class MakeRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("makeRequest.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String amount = request.getParameter("amt");
		String description= "I need money";//request.getParameter("desc");
		String typ = "1";		//insert actual value later 
		String status = "3";	//this is the default value
		String uID = request.getParameter("uID");
		
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			System.out.println(con.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		//test connection
		if (con != null){

			Reimbursement rei = new Reimbursement(Integer.parseInt(uID));
			rei.setAmt(Double.parseDouble(amount));
			rei.setrTtype(Integer.parseInt(typ));
			rei.setDesc(description);
			rei.setrTstatus(Integer.parseInt(status));
			
			ReimbursementDaoImpl reiDao = new ReimbursementDaoImpl();
			reiDao.createReimbursement(rei);
			
			int userID = rei.getAuthor();
			
			out.println(reiDao.retrieveReimbursementById(userID));
			
			//close connection
		    try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		    
		    response.sendRedirect("dashboard.jsp");
		}
		
		out.println(amount);
		out.println(description);
		out.println(typ);
	}

}