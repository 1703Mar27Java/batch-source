package com.Revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Revature.dao.BankAccountDAOimpl;
import com.Revature.dao.OverdraftException;
import com.Revature.dao.UserDAOimpl;
import com.Revature.domain.BankAccount;
import com.Revature.domain.User;

public class WithdrawServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer amt = Integer.parseInt(req.getParameter("amt"));
		BankAccountDAOimpl bankDAO = new BankAccountDAOimpl();
		UserDAOimpl userDAO = new UserDAOimpl();
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		BankAccount acct = (BankAccount) session.getAttribute("acct");
		if(acct.getUserID() == user.getUserID()){
			try {
				bankDAO.withdraw(acct, amt);
			} catch (OverdraftException e) {
				session.invalidate();
				req.setAttribute("message", "INSUFFICIENT FUNDS");
				req.getRequestDispatcher("bankAfterLogin.jsp").forward(req, resp);
			}
			List<BankAccount> accts = userDAO.retrieveAccounts(user.getUserID());
			session.setAttribute("accounts", accts);
			acct = bankDAO.retrieveAccountByID(acct.getAccountID());
			session.setAttribute("acct", acct);
			resp.sendRedirect("accountpage.jsp");
		}else{
			session.invalidate();
			req.setAttribute("message", "You are not allowed there");
			req.getRequestDispatcher("bankAfterLogin.jsp").forward(req, resp);
		}
	}
}
