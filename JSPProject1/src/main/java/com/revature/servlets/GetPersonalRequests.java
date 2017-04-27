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

import com.revature.dao.ReimbursementDaoImpl;
import com.revature.domain.Reimbursement;
import com.revature.util.ConnectionUtil;

/**
 * Servlet implementation class GetPersonalRequests
 */
public class GetPersonalRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPersonalRequests() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(); 
		
		int uid = (int) session.getAttribute("id");

		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			System.out.println(con.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		//test connection
		if (con != null){
			
			out.println("Connected");

			ReimbursementDaoImpl reiDao = new ReimbursementDaoImpl();
			List<Reimbursement> requests = reiDao.retrieveUserReimbursementByUserId(uid);
			
			out.println(requests);
			
			session.setAttribute("users", requests); 
			
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
