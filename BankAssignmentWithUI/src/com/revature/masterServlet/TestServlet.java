package com.revature.masterServlet;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.dao.BankAccountDAOImpl;
import com.revature.dao.BankUserDAOImpl;
import com.revature.domain.BankUser;
import com.revature.util.BankAccountUtil;
import com.revature.util.BankUserUtil;


public class TestServlet extends HttpServlet
	{
		private static final long serialVersionUID = -3288504055880482075L;
		private static final String filename = new File("C:\\Revature\\BankAssignmentWithUI\\connection.properties").getAbsolutePath();
		
		public static void main(String[] args) 
		{
			BankUser user = new BankUser();
			BankUserDAOImpl dao = new BankUserDAOImpl();
			BankAccountDAOImpl dao2 = new BankAccountDAOImpl();
			//System.out.println(BankUserUtil.createUserHelper("may", "may", "may", "may"));
			//System.out.println(Arrays.toString(BankUserUtil.getAllBankUsersHelper().toArray()));
			//System.out.println(BankAccountUtil.retrieveBankAcctHelper(900000).getAccountID());
			
			//System.out.println(BankUserUtil.deleteUserHelper("asdf"));
			/*
			user = BankUserUtil.getBankUserHelper("qqefasdkfjle");
			System.out.println(user.getUserID());
			System.out.println(user.getUserName());
			System.out.println(user.getFirstName());
			System.out.println(user.getLastName());
			System.out.println(user.getUserPassword());
			*/
			
			//BankAccountUtil.createAccountHelper(11, "Checking3", 5000);
			
			//System.out.println(dao2.retrieveAccount(59, filename));
			//System.out.println(BankAccountUtil.validWithdrawal(59, 1000));
			
			System.out.println(BankAccountUtil.getAccounts(11));
		}
		
		
		@Override 
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException 
		{
			
		
			Properties prop = new Properties();
			PrintWriter out = resp.getWriter();
			
			File file = new File(filename);
		
			String uName = req.getParameter("u_name");
			String uPass = req.getParameter("u_pass");
			
			/*
			if(uName.equals("admin") && uPass.equals("admin"))
			{
				out.println("<p>Successful login.</p>");
				out.println("<a href=\"Login.html\">go home</>");			
			}
			
			else
			{
				out.println("<p>Login failed.</p>");
				out.println("<a href=\"Login.html\">go home</>");				
			}
			*/
			
			
			try (InputStream in = new FileInputStream(file.getAbsolutePath()))
			{
				prop.load(in);
				if(uName.equals(prop.getProperty("username"))  && uPass.equals(prop.getProperty("password")))
				{
					out.println("<p>Successful login.</p>");
					out.println("<a href=\"Login.html\">go home</>");
					
					resp.sendRedirect("home.jsp");
				}
				else
				{
					out.println("<p>Login failed.</p>");
					out.println("<a href=\"Login.html\">go home</>");			}
			} 
			
			catch (FileNotFoundException e1) 
			{
				out.println("File not found on server.");
				e1.printStackTrace();
			} 
			
			catch (IOException e) 
			{
				out.println("IOException.");
				e.printStackTrace();
			}
			
		}
}
