package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bankExceptions.UserDoesntExistException;
import com.revature.bankExceptions.UserNameAlreadyExistsException;
import com.revature.util.UserUtil;

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("userToUpdate");
		try {
			UserUtil.tryUpdate(user, request.getParameter("username"), request.getParameter("password"));
			session.setAttribute("success", "Successfully updated user '"+user+"'");
		} catch (UserDoesntExistException | UserNameAlreadyExistsException e) {		
			session.setAttribute("error", e.getMessage());
		} finally{
			response.sendRedirect("super.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
