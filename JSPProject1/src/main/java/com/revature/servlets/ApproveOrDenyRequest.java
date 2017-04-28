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
 * Servlet implementation class ApproveOrDenyRequest
 */
public class ApproveOrDenyRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ApproveOrDenyRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		int rID = Integer.parseInt(request.getParameter("id"));
		int approve = Integer.parseInt(request.getParameter("appr"));
		
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
			ReimbursementDaoImpl reiDao = new ReimbursementDaoImpl();
		            
            //Reimbursement rei = reiDao.retrieveReimbursementById(rID);
            reiDao.updateReimbursement(rID, approve);
            
            //close connection
		     try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}   
		                
		}
		

	}

}
