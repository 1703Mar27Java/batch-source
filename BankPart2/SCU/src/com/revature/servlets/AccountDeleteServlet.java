package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bankExceptions.AccountDoesntExistsException;
import com.revature.bankExceptions.BankBalanceException;
import com.revature.domain.Account;
import com.revature.domain.User;
import com.revature.util.AccountUtil;

@WebServlet("/AccountDeleteServlet")
public class AccountDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		User user = (User) session.getAttribute("user");
		
		try {
			AccountUtil.tryDelete(user, account.getName());
		} catch (AccountDoesntExistsException e){
		} catch (BankBalanceException e) {
			session.setAttribute("error", e.getMessage());
		} finally{
			response.sendRedirect("main.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
