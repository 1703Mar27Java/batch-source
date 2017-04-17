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
import com.revature.dao.BankDAOImp;
import com.revature.domain.Account;
import com.revature.domain.User;
import com.revature.util.AccountUtil;


@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WithdrawServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Account account = (Account) session.getAttribute("account");			
		int ammount = Integer.parseInt(request.getParameter("amount"));
		BankDAOImp dao = new BankDAOImp();
		try {
			AccountUtil.withdraw(user, account.getName(), ammount);
			session.setAttribute("success", "Withdrew $"+ammount+" from "+account.getName());
			account.setTrans(dao.getTransaction(account));
			account.setBalance(account.getBalance()-ammount);
			session.setAttribute("account", account);
			response.sendRedirect("account.jsp");
		} catch (AccountDoesntExistsException e) {		
		} catch(BankBalanceException e){
			session.setAttribute("error", e.getMessage());
			response.sendRedirect("account.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
