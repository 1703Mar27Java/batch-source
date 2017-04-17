package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bankExceptions.UserDoesntExistException;
import com.revature.util.UserUtil;


@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserDeleteServlet() {
        super();       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("userToUpdate");
		try {
			UserUtil.tryDelete(user);
			session.setAttribute("success", "Successfully deleted user '"+user+"'");
		} catch (UserDoesntExistException e) {			
		} finally{
			response.sendRedirect("super.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
