package com.revature.login;

import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.BankAccount;
import com.revature.domain.User;
import com.revature.util.ConnectionUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 * Servlet implementation class Login
 */
@WebServlet("/lin")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		
		RequestDispatcher rd = req.getRequestDispatcher("mainPage.jsp");
    	rd.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = ConnectionUtil.getConnection();
			System.out.println(con.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String dataType = "";
		
		PrintWriter out = resp.getWriter();
		out.println("<p>did the post</p>");
		out.println("<a href=\"homePage.html\">go home</>");
		String n1 = req.getParameter("un");
		String n2 = req.getParameter("pw");
		
		out.println("<p>Hello: "+n1+"</p>");
            
    		/*bankAccount = bankDao.retrieveAccountById(userID);
    		System.out.println(bankAccount);*/
            
            /*forward*/
    		if (con != null){
    			 //try to incorporate dao files into login
                UserDaoImpl userDao = new UserDaoImpl();
                BankAccountDaoImpl bankDao = new BankAccountDaoImpl();
                User user = userDao.retrieveUserByLoginInfo(n1, n2);
                
                //see if username and password are right
                if (user != null){
                	int userID = user.getUserID();
                	String userName = user.getUserName();
                	String password = user.getPassword();
                	out.println("<table border=1 width=50% height=50>");
                	out.println("<tr><th>USERID</th><th>USERNAME</th><tr>");
                	out.println("<tr><td>" + userID + "</td>" + "<td>" + userName + "</td></tr>");
	            
                	//req.setAttribute("userName", userName); 
                	
		             BankAccount bank = bankDao.retrieveAccountById(userID);
		             int bankID = bank.getBank_account_id();
		             String acctName = bank.getBank_account_name();
		             double balance = bank.getBalance();
		             System.out.println(acctName);
		             
		            HttpSession session = req.getSession(); 
	                session.setAttribute("userId", Integer.toString(userID));
	                session.setAttribute("userName", userName);
	                session.setAttribute("password", password);
		             
		             if (bank != null){
		            	 System.out.println("not null");
		            	 session.setAttribute("bankId", Integer.toString(bankID));
		            	 session.setAttribute("accountName", acctName);
		            	 session.setAttribute("balance", Double.toString(balance));
		             }
                	
                	/*RequestDispatcher rd = req.getRequestDispatcher("mainPage.jsp");
                	rd.forward(req, resp);*/
		             
		            try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		            
                	req.getRequestDispatcher("loading.jsp").forward(req, resp); 
					System.out.println("forwarded");
                }
                
                else{
                	resp.sendRedirect("homePage.html");
                }
                
	            
   			/*RequestDispatcher rd = req.getRequestDispatcher("loading.html");
			rd.forward(req, resp);
			System.out.println("forwarded");*/
		}
	}

}
