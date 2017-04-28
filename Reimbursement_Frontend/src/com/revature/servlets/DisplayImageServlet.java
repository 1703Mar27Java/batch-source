package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.revature.domain.Reimbursement;
import com.revature.domain.Roles;
import com.revature.domain.Status;
import com.revature.domain.Type;
import com.revature.util.ConnectionUtil;

/**
 * Servlet implementation class DisplayImageServlet
 */
@WebServlet("/DisplayImageServlet")
public class DisplayImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayImageServlet() {
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

		ArrayList<Reimbursement> reArray = new ArrayList<Reimbursement>();
		try {
			Connection con = ConnectionUtil.getConnection();

			String sql = "SELECT * FROM ERS_REIMBURSEMENTS ORDER BY U_ID";
			PreparedStatement pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int id = rs.getInt(1);
				int amt = rs.getInt(2);
				String desc = rs.getString(3);
				byte[] blob = rs.getBytes(4);
				Timestamp submit = rs.getTimestamp(5);
				Timestamp resolve = rs.getTimestamp(6);
				int eId = rs.getInt(7);
				int mId = rs.getInt(8);
				int type = rs.getInt(9);
				int stat = rs.getInt(10);
				String filename = rs.getString(11);

				Reimbursement reim = new Reimbursement();
				reim.setReimbursementId(id);
				reim.setReimbursementAmount(amt);
				reim.setReimbursementDescription(desc);
				reim.setImage(blob);
				reim.setReimbursementSubmitDate(submit.toString());
				reim.setReimbursementResolveDate(resolve.toString());
				reim.setEmployeeAuthor(eId);
				reim.setEmployeeResolver(mId);

				switch (type) {
				case 1:
					reim.setReimbursementType(Type.Rent);
					break;
				case 2:
					reim.setReimbursementType(Type.Gas);
					break;
				case 3:
					reim.setReimbursementType(Type.Books);
					break;
				case 4:
					reim.setReimbursementType(Type.Tech);
					break;
				case 5:
					reim.setReimbursementType(Type.Food);
					break;
				case 6:
					reim.setReimbursementType(Type.Travel);
					break;
				default:
					break;
				}

				switch (stat) {
				case 1:
					reim.setReimbursementStatus(Status.Pending);
					break;
				case 2:
					reim.setReimbursementStatus(Status.Approved);
					break;
				case 3:
					reim.setReimbursementStatus(Status.Declined);
					break;
				case 4:
					reim.setReimbursementStatus(Status.New);
					break;
				default:
					break;

				}

				reArray.add(reim);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// trump.jpg, putin.png
		String imageFileName = reArray.get(1).getFileName();
		System.out.println("File Name: " + imageFileName);
		System.out.println("encoding: " + reArray.get(1).getEncodedImage());
		HttpSession sesh = request.getSession();
		
		sesh.setAttribute("Encoded", "data:image/jpeg;base64," + reArray.get(1).getEncodedImage());
		sesh.setAttribute("array", reArray);
		
		// String image = new
		// String(Base64.getEncoder().encode(reArray.get(1).getImageData()),
		// "UTF-8");
		// image/jpg
		// image/png
		// String contentType =
		// this.getServletContext().getMimeType(imageFileName);
		// System.out.println("Content Type: "+ contentType);

		// response.setHeader("Content-Type", contentType);

		// response.setHeader("Content-Length",
		// String.valueOf(reArray.get(1).getImageData().length));

		// response.setHeader("Content-Disposition", "inline; filename=\"" +
		// reArray.get(1).getFilename() + "\"");

		// Write image data to Response.
		// response.getOutputStream().write(reArray.get(1).getImageData());
		String refresh = request.getParameter("userview");
		System.out.println(refresh);
		if (refresh == null) {
			response.sendRedirect("/MyERS/managerhome.jsp");
			return;
		}

		if (refresh.equals("View/Refresh")) {
			response.sendRedirect("/MyERS/employeeviewre.jsp");
		} else {
			response.sendRedirect("/MyERS/managerhome.jsp");
		}

	}

}
