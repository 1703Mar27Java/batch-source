package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImp;
import com.revature.domain.Reimbursement;
import com.revature.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReimbursementDAO rdao = new ReimbursementDAOImp();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		double amt= Double.parseDouble(request.getParameter("amount"));
		String type = request.getParameter("type").toUpperCase();
		String description = request.getParameter("description");
		Part filePart = request.getPart("receipt");
		InputStream input = filePart.getInputStream();

			
		Reimbursement reim = new Reimbursement(amt, description, input, null, null, null, null, type, "PENDING");
		
		rdao.createReimbursement(reim, user.getId());
		
		request.getRequestDispatcher("home").forward(request,response);	
		
	}

}
