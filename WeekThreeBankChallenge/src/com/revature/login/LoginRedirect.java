package com.revature.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/loginRedirect")
public class LoginRedirect extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		/*forward*/
		RequestDispatcher rd = req.getRequestDispatcher("mainPage.html");
		rd.forward(req, resp);
		System.out.println("forwarded");
		
		/*redirect*/
		/*resp.sendRedirect("mainPage.html");
		System.out.println("redirected");*/
		
	}
}