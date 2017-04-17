package com.revature.masterServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.domain.BankUser;
import com.revature.util.BankUserUtil;

public class SuperUserView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SuperUserView() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession sesh = req.getSession();
		if(sesh.getAttribute("superLogIn").equals("false"))
		{
			resp.sendRedirect("login.html");
		}
		
		else
		{
			String uName = req.getParameter("v_u_name");
			BankUser user = BankUserUtil.getBankUserHelper(uName);
			
			int userID = user.getUserID();
			String username = user.getUserName();
			String password = user.getUserPassword();
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			
			if(user.getUserID() != 0)
			{
				sesh.setAttribute("userID", userID);
				sesh.setAttribute("username", username);
				sesh.setAttribute("password", password);
				sesh.setAttribute("firstName", firstName);
				sesh.setAttribute("lastName", lastName);
				resp.sendRedirect("superViewUserDetails.jsp");
			}
			
			else
			{
				//send to error page
				resp.sendRedirect("superViewError.html");
			}
		}
	}
}
