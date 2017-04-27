package com.revature.dao;

import java.sql.*;
import java.util.*;

import com.revature.bean.ERS_REIMBURSEMENTS;
import com.revature.util.ConnectionUtil;

public class ERS_REIMBURSEMENTSDAOImpl implements ERS_REIMBURSEMENTSDAO {

	@Override
	public List<ERS_REIMBURSEMENTS> loadAll() throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet result = null;
		String sql = "SELECT * FROM ERS_REIMBURSEMENTS ORDER BY R_ID ASC ";
		List<ERS_REIMBURSEMENTS> searchResults = new ArrayList<>();

		try {
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();

			while (result.next()) {
				ERS_REIMBURSEMENTS temp = new ERS_REIMBURSEMENTS();

				temp.setR_ID(result.getInt("R_ID"));
				temp.setR_AMOUNT(result.getInt("R_AMOUNT"));
				temp.setR_DESCRIPTION(result.getString("R_DESCRIPTION"));
				temp.setR_RECEIPT(result.getBinaryStream("R_RECEIPT"));
				temp.setR_SUBMITTED(result.getTimestamp("R_SUBMITTED"));
				temp.setR_RESOLVED(result.getTimestamp("R_RESOLVED"));
				temp.setU_ID_AUTHOR(result.getInt("U_ID_AUTHOR"));
				temp.setU_ID_RESOLVER(result.getInt("U_ID_RESOLVER"));
				temp.setRT_TYPE(result.getInt("RT_TYPE"));
				temp.setRS_STATUS(result.getInt("RS_STATUS"));

				searchResults.add(temp);
			}

		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}

		return searchResults;
	}

	@Override
	public void create(ERS_REIMBURSEMENTS reimb) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			sql = "INSERT INTO ERS_REIMBURSEMENTS ( R_AMOUNT, R_DESCRIPTION, R_RECEIPT, "
					+ "R_SUBMITTED, R_RESOLVED, U_ID_AUTHOR, "
					+ "U_ID_RESOLVER, RT_TYPE, RS_STATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, reimb.getR_AMOUNT());
			stmt.setString(2, reimb.getR_DESCRIPTION());
			stmt.setBlob(3, reimb.getR_RECEIPT());
			stmt.setTimestamp(4, reimb.getR_SUBMITTED());
			stmt.setTimestamp(5, reimb.getR_RESOLVED());
			stmt.setInt(6, reimb.getU_ID_AUTHOR());
			stmt.setInt(7, reimb.getU_ID_RESOLVER());
			stmt.setInt(8, reimb.getRT_TYPE());
			stmt.setInt(9, reimb.getRS_STATUS());

			int rowcount = stmt.executeUpdate();
			if (rowcount != 1) {
				throw new SQLException("PrimaryKey Error when updating DB!");
			}

		} finally {
			if (stmt != null)
				stmt.close();
		}

		sql = "SELECT SQ_ERS_REIMBURSEMENTS_PK.currval FROM dual";

		try {
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();

			if (result.next()) {
				reimb.setR_ID((int) result.getLong(1));
			} else {
				throw new SQLException("Unable to find primary-key for created object!");
			}
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}
	}

	@Override
	public void submit(double amt, String desc, int id, String type) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "BEGIN SP_ERS_SUBMIT (?,?,?,?)";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setDouble(1, amt);
			cstmt.setString(2, desc);
			cstmt.setInt(3, id);
			cstmt.setString(4, type);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void resolve(int id, String status, int manager) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "BEGIN SP_ERS_RESOLVE (?, ?, ?)";
			CallableStatement cstmt = conn.prepareCall(sql);
			if (status.equals("Approve"))
				status = "Approved";
			else if (status.equals("Deny"))
				status = "Denied";
			cstmt.setInt(1, id);
			cstmt.setString(2, status);
			cstmt.setInt(3, manager);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ERS_REIMBURSEMENTS reimb) throws SQLException {
		String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ?, R_RECEIPT = ?, "
				+ "R_SUBMITTED = ?, R_RESOLVED = ?, U_ID_AUTHOR = ?, "
				+ "U_ID_RESOLVER = ?, RT_TYPE = ?, RS_STATUS = ? WHERE (R_ID = ? ) ";
		PreparedStatement stmt = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, reimb.getR_AMOUNT());
			stmt.setString(2, reimb.getR_DESCRIPTION());
			stmt.setBlob(3, reimb.getR_RECEIPT());
			stmt.setTimestamp(4, reimb.getR_SUBMITTED());
			stmt.setTimestamp(5, reimb.getR_RESOLVED());
			stmt.setInt(6, reimb.getU_ID_AUTHOR());
			stmt.setInt(7, reimb.getU_ID_RESOLVER());
			stmt.setInt(8, reimb.getRT_TYPE());
			stmt.setInt(9, reimb.getRS_STATUS());

			stmt.setInt(10, reimb.getR_ID());

			int rowcount = stmt.executeUpdate();
			if (rowcount == 0) {
				throw new SQLException("Object could not be saved! (PrimaryKey not found)");
			}
			if (rowcount > 1) {
				throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
			}
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

}
