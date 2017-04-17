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
import com.revature.domain.BankAccount;
import com.revature.util.ConnectionUtil;

/**
 * Servlet implementation class ViewAllAccts
 */
@WebServlet("/ViewAllAccts")
public class ViewAllAccts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ViewAllAccts(){
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("view all accounts");
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
			//manipulate balance entry for bankaccount table in database
            BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
            
        	HttpSession session = request.getSession();
        	String userId = (String)session.getAttribute("userId");
        	int userIdInt = Integer.parseInt(userId);
        	List<BankAccount> accounts = bankDao.retrieveAccountsById(userIdInt);
			
			
			out.println(accounts);
			
			session.setAttribute("accounts", accounts);
			
			//request.getRequestDispatcher("mainPage.jsp").forward(request, response);
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	            
		}

	}

}
