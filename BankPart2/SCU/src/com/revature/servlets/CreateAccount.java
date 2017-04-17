package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bankExceptions.AccountAlreadyExistsException;
import com.revature.domain.User;
import com.revature.util.AccountUtil;

@WebServlet("/createAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountName = request.getParameter("name"); 
		HttpSession session = request.getSession();
			try {
				User user = (User) session.getAttribute("user");
				AccountUtil.tryCreate(user, accountName);
				session.setAttribute("success", "Account '"+accountName+"' successfully created");
				response.sendRedirect("main.jsp");
				session.setAttribute("error", null);
			} catch (AccountAlreadyExistsException e) {
				session.setAttribute("error", "*Account '"+accountName+"' already exists");
				RequestDispatcher rd = request.getRequestDispatcher("new.jsp");
				rd.forward(request, response);
			}
	}

}
