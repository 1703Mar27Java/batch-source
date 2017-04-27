package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImp;
import com.revature.domain.Reimbursement;


public class ReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReimbursementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		ReimbursementDAO rdao = new ReimbursementDAOImp();
		int rId = Integer.parseInt(request.getParameter("newR"));

		Reimbursement reim = rdao.getReimbursementById(rId);
		
		
		
		session.setAttribute("currentReim", reim);
		
		request.getRequestDispatcher("reimbursement.jsp").forward(request,response);	
	}

}
