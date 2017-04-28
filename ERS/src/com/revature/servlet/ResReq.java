package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.RequestDAOImpl;
import com.revature.util.mailer;

/**
 * Servlet implementation class ResReq
 */
@WebServlet("/ResReq")
public class ResReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResReq() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(); 
		
		String mgr=(String) session.getAttribute("uName");
		String stat=request.getParameter("status");
		int rid=Integer.parseInt(request.getParameter("rid"));
		System.out.println("in resreq, with " +mgr+" "+stat+" "+rid);
		//public void resolveReq(int rid, String status, String mgr) 
		RequestDAOImpl rDAO = new RequestDAOImpl();
		rDAO.resolveReq(rid, stat, mgr);
		String email = rDAO.getEmailByRid(rid);
		mailer.mail( email,  "A manager has resolved your reimbursement request with id "
				+rid+". Please log on to confirm the details");
		
	}

}
