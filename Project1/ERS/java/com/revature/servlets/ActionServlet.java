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
import com.revature.domain.User;


public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ActionServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ReimbursementDAO rdao = new ReimbursementDAOImp();
		String action = request.getParameter("action");
		User user = (User) session.getAttribute("user");
		
		Reimbursement reim = (Reimbursement) session.getAttribute("currentReim");
		
		if(action.equals("app")){
			reim.setStatus("APPROVED");
		} else {
			reim.setStatus("DECLINED");
		}
		
		rdao.updateReimbursement(reim, user.getId());
		
		
	}

}
