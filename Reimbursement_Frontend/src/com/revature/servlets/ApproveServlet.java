package com.revature.servlets;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.revature.dao.ReimbursementDaoImpl;
import com.revature.domain.Employee;
import com.revature.domain.Reimbursement;
import com.revature.domain.Status;


/**
 * Servlet implementation class ApproveServlet
 */
@WebServlet("/ApproveServlet")
public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Reimbursement reimbursement = new Reimbursement();
		Employee employee = new Employee();
		ReimbursementDaoImpl rDao = new ReimbursementDaoImpl();

		Date date = new Date();
		String newDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
		reimbursement.setReimbursementResolveDate(newDate);
		
		//reimbursement.setReimbursementStatus(Status.New);

		HttpSession session = request.getSession();
		
		

		employee.setEmployeeID(Integer.valueOf(session.getAttribute("id").toString()));
		reimbursement.setEmployeeResolver(employee.getEmployeeID());

		reimbursement.setReimbursementStatus(Status.Approved);

		int r_id = Integer.valueOf(request.getParameter("RID"));
		
		System.out.println("sending out update");
		rDao.updateReimbursement(reimbursement, r_id);
	}

}
