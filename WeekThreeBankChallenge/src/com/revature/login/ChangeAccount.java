package com.revature.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ChangeAccount
 */
@WebServlet("/ChangeAccount")
public class ChangeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ChangeAccount() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();

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
			
			request.getRequestDispatcher("ChangeAccount.jsp").forward(request, response);
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	            
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Change bank account");
		
		String id = request.getParameter("id");
		
		//also should check to see if username and/or password are already taken
		if (id.equals("") || id == null){
			response.sendRedirect("ChangAccount.jsp");
		}
		else{
			//now we can allow for the creation of a user
			
			//establish connection
			Connection con = null;
			try {
				con = ConnectionUtil.getConnection();
				System.out.println(con.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (con != null){
				out.println("connected yet again");
				
				//make a user and userdao object
				HttpSession session = request.getSession();
				int acctID = Integer.parseInt((String)session.getAttribute("id"));
				
				BankAccount bankAccount = new BankAccount();
				BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
				//bankAccount = bankDao.retrieveAccountByAcctId(22);
				
				 if (bankAccount != null){
	            	 out.println("not nullsie");
	            	 session.setAttribute("bankId", Integer.toString(bankAccount.getBank_account_id()));
	            	 session.setAttribute("accountName", bankAccount.getBank_account_name());
	            	 session.setAttribute("balance", Double.toString(bankAccount.getBalance()));
	             }
				
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
				response.sendRedirect("ChangeAccount.jsp");
			}
		}

	}

}
