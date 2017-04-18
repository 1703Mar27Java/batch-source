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
import com.revature.domain.BankAccount;
import com.revature.util.ConnectionUtil;

/**
 * Servlet implementation class ChangeAcctBalance
 */
@WebServlet("/ChangeAcctBalance")
public class ChangeAcctBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("deposit or withdrawal");
		String amount = request.getParameter("amount");
		out.println(amount);
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
        	String accountId = (String)session.getAttribute("bankId");
        	int accountIdInt = Integer.parseInt(accountId);
			BankAccount bank = bankDao.retrieveAccountByAcctId(accountIdInt);
			
			
			if ((request.getParameter("Withdrawal") != null) && (request.getParameter("Deposit") == null)){
				//update balance
				out.println("Withdraw");
				bankDao.updateAccount(bank, "WITHDRAW", Integer.parseInt(amount));
				
			}
			else if ((request.getParameter("Deposit") != null) && (request.getParameter("Withdrawal") == null)){
				//update balance
				out.println("Deposit");
				bankDao.updateAccount(bank, "DEPOSIT", Integer.parseInt(amount));
			}
			
			out.println(bank.getBalance());
			
			session.setAttribute("balance", Double.toString(bank.getBalance()));
			
			request.getRequestDispatcher("mainPage.jsp").forward(request, response);
			
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
	            
		}
		
		
	}

}
