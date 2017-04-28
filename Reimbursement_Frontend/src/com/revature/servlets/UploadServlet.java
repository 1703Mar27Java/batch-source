package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.dao.ReimbursementDaoImpl;
import com.revature.domain.*;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig(maxFileSize = 16177215)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Reimbursement reimbursement = new Reimbursement();
		Employee employee = new Employee();
		ReimbursementDaoImpl rDao = new ReimbursementDaoImpl();

		String amount = request.getParameter("amt");

		reimbursement.setReimbursementAmount(Integer.valueOf(amount));

		String description = request.getParameter("desc");
		reimbursement.setReimbursementDescription(description);

		Date date = new Date();
		String newDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
		reimbursement.setReimbursementSubmitDate(newDate);
		
		
		if (Integer.valueOf(request.getParameter("typ")) == 1)
			reimbursement.setReimbursementType(Type.Rent);
		if (Integer.parseInt(request.getParameter("typ")) == 2)
			reimbursement.setReimbursementType(Type.Gas);
		if (Integer.parseInt(request.getParameter("typ")) == 3)
			reimbursement.setReimbursementType(Type.Books);
		if (Integer.parseInt(request.getParameter("typ")) == 4)
			reimbursement.setReimbursementType(Type.Tech);
		if (Integer.parseInt(request.getParameter("typ")) == 5)
			reimbursement.setReimbursementType(Type.Food);
		if (Integer.parseInt(request.getParameter("typ")) == 6)
			reimbursement.setReimbursementType(Type.Travel);

		// reimbursement.setEmployeeAuthor(session.getAttribute("id"));
		reimbursement.setReimbursementStatus(Status.Pending);

		HttpSession session = request.getSession();

		employee.setEmployeeID(Integer.valueOf(session.getAttribute("id").toString()));
		reimbursement.setEmployeeAuthor(employee.getEmployeeID());

		Part filePart = request.getPart("rec");
		InputStream input = null;

		if (filePart != null)
			input = filePart.getInputStream();

		String fileName = filePart.getSubmittedFileName();

		reimbursement.setReimbursementReceipt(fileName);

		rDao.createReimbursement(employee, reimbursement, input);
	}
}
