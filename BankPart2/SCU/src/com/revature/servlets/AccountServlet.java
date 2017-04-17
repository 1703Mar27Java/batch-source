package com.revature.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.BankDAOImp;
import com.revature.domain.Account;
import com.revature.domain.User;


@WebServlet("/accountView")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AccountServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> e =request.getParameterNames();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		BankDAOImp dao = new BankDAOImp();
		Account a = user.getAccount(e.nextElement());
		a.setTrans(dao.getTransaction(a));
		session.setAttribute("account", a);
		response.sendRedirect("account.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
