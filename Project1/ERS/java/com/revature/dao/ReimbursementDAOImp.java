package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.domain.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImp implements ReimbursementDAO {

	public void createReimbursement(Reimbursement reim, int author) {
		try (Connection con = ConnectionUtil.getConnection()) {
			String createCall = "{CALL SP_SUBMIT_REQUEST (?, ?, ?, ?, ?)}";
			CallableStatement cstmt = con.prepareCall(createCall);

			cstmt.setInt(1, author);
			cstmt.setDouble(2, reim.getAmount());
			cstmt.setString(3, reim.getDescription());
			cstmt.setBlob(4, reim.getReceipt());
			cstmt.setInt(5, encodeType(reim.getType()));

			cstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateReimbursement(Reimbursement reim, int resolver) {

		try (Connection con = ConnectionUtil.getConnection()) {
			String createCall = "{CALL SP_RESOLVE_REQUEST (?, ?, ?)}";
			CallableStatement cstmt = con.prepareCall(createCall);

			cstmt.setInt(1, reim.getId());
			cstmt.setInt(2, resolver);
			cstmt.setInt(3, encodeStatus(reim.getStatus()));

			cstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Reimbursement getReimbursementById(int id) {
		Reimbursement reim = null;
		try (Connection con = ConnectionUtil.getConnection()) {
			String queryString = "SELECT " + "R_ID ID, " + "R_AMOUNT AMOUNT, " + "R_DESCRIPTION DESCRIPTION, "
					+ "R_RECEIPT RECEIPT, " + "R_SUBMITTED SUBMITTED, " + "R_RESOLVED RESOLVED, "
					+ "T.U_USERNAME AUTHOR, " + "USERS.U_USERNAME RESOLVER, " + "RS_STATUS STATUS ," + "RT_TYPE TYPE "
					+ "FROM ( " + "SELECT * FROM REIMBURSEMENTS "
					+ "INNER JOIN REIMBURSEMENT_STATUS ON REIMBURSEMENTS.RS_ID = REIMBURSEMENT_STATUS.RS_ID "
					+ "INNER JOIN REIMBURSEMENT_TYPE ON REIMBURSEMENTS.RT_ID = REIMBURSEMENT_TYPE.RT_ID "
					+ "INNER JOIN USERS ON U_ID_AUTHOR = USERS.U_ID) T LEFT JOIN USERS ON T.U_ID_RESOLVER = USERS.U_ID WHERE R_ID =?";

			PreparedStatement pstmt = con.prepareStatement(queryString);

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {			
				reim = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), null, rs.getString(5).substring(5,10)+"-"+rs.getString(5).substring(0,4),
						null, rs.getString(7), rs.getString(8), rs.getString(10), rs.getString(9));
				reim.setPic(rs.getBlob(4).getBytes(1,(int) rs.getBlob(4).length()));
				if(rs.getString(6) != null){
					 reim.setResolved(rs.getString(6).substring(5,10)+"-"+rs.getString(6).substring(0,4));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reim;
	}
	
	
	public ArrayList<Reimbursement> getReimbursements() {
		ArrayList<Reimbursement> reims = new ArrayList<Reimbursement>();
		try (Connection con = ConnectionUtil.getConnection()) {
			String queryString = "SELECT " + "R_ID ID, " + "R_AMOUNT AMOUNT, " + "R_DESCRIPTION DESCRIPTION, "
					+ "R_RECEIPT RECEIPT, " + "R_SUBMITTED SUBMITTED, " + "R_RESOLVED RESOLVED, "
					+ "T.U_USERNAME AUTHOR, " + "USERS.U_USERNAME RESOLVER, " + "RS_STATUS STATUS ," + "RT_TYPE TYPE "
					+ "FROM ( " + "SELECT * FROM REIMBURSEMENTS "
					+ "INNER JOIN REIMBURSEMENT_STATUS ON REIMBURSEMENTS.RS_ID = REIMBURSEMENT_STATUS.RS_ID "
					+ "INNER JOIN REIMBURSEMENT_TYPE ON REIMBURSEMENTS.RT_ID = REIMBURSEMENT_TYPE.RT_ID "
					+ "INNER JOIN USERS ON U_ID_AUTHOR = USERS.U_ID) T LEFT JOIN USERS ON T.U_ID_RESOLVER = USERS.U_ID ORDER BY SUBMITTED DESC";

			PreparedStatement pstmt = con.prepareStatement(queryString);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				Reimbursement reim = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getBinaryStream(4), rs.getString(5).substring(5,10)+"-"+rs.getString(5).substring(0,4),
						null, rs.getString(7), rs.getString(8), rs.getString(10), rs.getString(9));
				reims.add(reim);
				if(rs.getString(6) != null){
					 reim.setResolved(rs.getString(6).substring(5,10)+"-"+rs.getString(6).substring(0,4));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reims;
	}
	
	public ArrayList<Reimbursement> getReimbursements(int id) {
		ArrayList<Reimbursement> reims = new ArrayList<Reimbursement>();
		try (Connection con = ConnectionUtil.getConnection()) {
			String queryString = "SELECT " + "R_ID ID, " + "R_AMOUNT AMOUNT, " + "R_DESCRIPTION DESCRIPTION, "
					+ "R_RECEIPT RECEIPT, " + "R_SUBMITTED SUBMITTED, " + "R_RESOLVED RESOLVED, "
					+ "T.U_USERNAME AUTHOR, " + "USERS.U_USERNAME RESOLVER, " + "RS_STATUS STATUS ," + "RT_TYPE TYPE "
					+ "FROM ( " + "SELECT * FROM REIMBURSEMENTS "
					+ "INNER JOIN REIMBURSEMENT_STATUS ON REIMBURSEMENTS.RS_ID = REIMBURSEMENT_STATUS.RS_ID "
					+ "INNER JOIN REIMBURSEMENT_TYPE ON REIMBURSEMENTS.RT_ID = REIMBURSEMENT_TYPE.RT_ID "
					+ "INNER JOIN USERS ON U_ID_AUTHOR = USERS.U_ID) T LEFT JOIN USERS ON T.U_ID_RESOLVER = USERS.U_ID WHERE T.U_ID= ? ORDER BY SUBMITTED DESC";

			PreparedStatement pstmt = con.prepareStatement(queryString);
			
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reimbursement reim = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getBinaryStream(4), rs.getString(5).substring(5,10)+"-"+rs.getString(5).substring(0,4),
						null, rs.getString(7), rs.getString(8), rs.getString(10), rs.getString(9));
				reims.add(reim);
				if(rs.getString(6) != null){
					 reim.setResolved(rs.getString(6).substring(5,10)+"-"+rs.getString(6).substring(0,4));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reims;
	}
	

	private int encodeType(String type) {
		int id = 0;

		switch (type) {
		case "TRAVEL":
			id = 0;
			break;
		case "CERTIFICATION":
			id = 1;
			break;
		case "MATERIAL":
			id = 2;
			break;
		case "HEALTH":
			id = 3;
			break;
		case "OTHER":
			id = 4;
			break;
		}

		return id;
	}

	private int encodeStatus(String type) {
		int id = 0;

		switch (type) {
		case "PENDING":
			id = 0;
			break;
		case "APPROVED":
			id = 1;
			break;
		case "DECLINED":
			id = 2;
			break;
		}

		return id;
	}

}
