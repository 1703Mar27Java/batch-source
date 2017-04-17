package com.pbjbank.appservlets;


	import java.io.IOException;
//	import java.io.PrintWriter;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import com.pbjbank.dao.BankUserDAOImpl;
	import com.pbjbank.util.ConnectionUtil;

	
	public class UserServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//this is a direct connection to the database itself
		  ConnectionUtil n = new ConnectionUtil();
		  System.out.println("Connected to dabatabase: "+ n);
			
			//this is the class that creates a new object to access the 
			//methods that access information from the database 
			BankUserDAOImpl dao = new BankUserDAOImpl();
		
			//this are the inputs that come directly from the home.jsp page (or index.html page)
			//where people would actually log into the website
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			//use the dao object to call a method in the BandUserDAOImpl class to 
			//pull info from the database and run a string parameter through it.
			//the retrieveUserName method in the BankUserDAOImpl class  requires one.
			dao.retrieveUserName(username, password);
			
			
			
			//The response object is a JSP implicit object that takes the response
			//of the user sending the request and redirects them to a different page (returningUser.jsp).
			response.sendRedirect("returningUser.jsp"); 
		
			/*To do a forward, you would use the RequestDispatcher:
			 * RequestDispatcher rd = request.getRequestDispatcher("name of page");
			 * rd.forward(request, response);
			 * */
			
			//printwriter prints the response back out to the page
		//	PrintWriter out = response.getWriter();
	/*		for(User_Logon b:dao.retrieveAllUser_Logons()){
				out.println("<p>"+b.toString()+"</p>");
			}*/
		}
	

}
