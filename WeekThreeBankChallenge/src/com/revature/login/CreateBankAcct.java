package com.revature.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

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
 * Servlet implementation class CreateBankAcct
 */
@WebServlet("/CreateBankAcct")
public class CreateBankAcct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateBankAcct() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.sendRedirect("MakeAccount.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Create bank account");
		
		String bankName = request.getParameter("bankName");
		
		//also should check to see if username and/or password are already taken
		if (bankName.equals("") || bankName == null){
			response.sendRedirect("MakeAccount.jsp");
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
				HttpSession session = request.getSession();
				int userID = Integer.parseInt((String)session.getAttribute("userId"));
				
				BankAccount bankAccount = new BankAccount(bankName, 0.0, userID);
				BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
				bankDao.createAccount(bankAccount);

				
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
