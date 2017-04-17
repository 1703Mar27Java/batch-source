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
 * Servlet implementation class ChangeAcctBalance
 */
@WebServlet("/ChangeAcctBalance")
public class ChangeAcctBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("deposit or withdrawal");
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
			
			//update balance
			bankDao.updateAccount(bank, "WITHDRAW", 1);
			
			out.println(bank.getBalance());
			
			session.setAttribute("balance", Double.toString(bank.getBalance()));
			
			request.getRequestDispatcher("mainPage.jsp").forward(request, response);
			
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	            
		}
		
		
	}

}
