package com.revature.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.beans.Reimbursements;
import com.revature.beans.ReimbursementsStatus;
import com.revature.beans.ReimbursementsType;
import com.revature.beans.User;

public class ReimbursementsDAOImple implements ReimbursementsDAO {

	private Connection conn;

	public ReimbursementsDAOImple() {
	}

	public ReimbursementsDAOImple(Connection conn) {
		this.conn = conn;
	}

	public void saveNewReimbursement(Reimbursements reim) throws SQLException {

		String sql = "INSERT INTO ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_SUBMITTED, "
				+ "REIMB_AUTHOR, REIMB_TYPE_ID, REIMB_DESCRIPTION,REIMB_STATUS_ID) VALUES(? , ? , ? , ? , ? , ?)";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setDouble(1, reim.getrAmount());

		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());

		stmt.setTimestamp(2, time);
		stmt.setInt(3, reim.getrAuthor().getUserID());
		stmt.setInt(4, reim.getTypeID());
		stmt.setString(5, reim.getrDescription());
		stmt.setInt(6, 1);
		
		stmt.executeUpdate();

	}

	public List<Reimbursements> getUserReimbursements(int userID) throws SQLException {
		
		String sql = "SELECT * FROM ERS_USERS U INNER JOIN ERS_REIMBURSEMENT R " + "ON U.ERS_USERS_ID = R.REIMB_AUTHOR"
				+ " WHERE ERS_USERS_ID = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, userID);
		stmt.executeQuery();

		ResultSet rs = stmt.executeQuery();

		List<Reimbursements> reimbList = new ArrayList<Reimbursements>();

		while (rs.next()) {
			ReimbursementsType type = getType(rs.getInt("REIMB_TYPE_ID"));
			ReimbursementsStatus status = getStatus(rs.getInt("REIMB_STATUS_ID"));
			User author = new UserDAOImple(conn).getUserbyID(rs.getInt("REIMB_AUTHOR"));
			User resolver = new UserDAOImple(conn).getUserbyID(rs.getInt("REIMB_RESOLVER"));

			reimbList.add(new Reimbursements(
					rs.getInt("REIMB_ID"), 
					rs.getDouble("REIMB_AMOUNT"),
					rs.getTimestamp("REIMB_SUBMITTED"), 
					rs.getTimestamp("REIMB_RESOLVED"),
					rs.getString("REIMB_DESCRIPTION"), 
					rs.getBlob("REIMB_RECEIPT"), 
					author, 
					resolver,
					rs.getInt("REIMB_STATUS_ID"), 
					rs.getInt("REIMB_TYPE_ID"), 
					status, 
					type));
		}

		return reimbList;

	}

	public List<Reimbursements> getAllReimbursements() throws SQLException {
		String sql = "SELECT * FROM ERS_REIMBURSEMENT";
		PreparedStatement stmt = conn.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		List<Reimbursements> allReimbList = new ArrayList<Reimbursements>();

		while (rs.next()) {

			ReimbursementsType type = getType(rs.getInt("REIMB_TYPE_ID"));
			ReimbursementsStatus status = getStatus(rs.getInt("REIMB_STATUS_ID"));

			User author = new UserDAOImple(conn).getUserbyID(rs.getInt("REIMB_AUTHOR"));
			User resolver = new UserDAOImple(conn).getUserbyID(rs.getInt("REIMB_RESOLVER"));

			allReimbList.add(new Reimbursements(
					rs.getInt("REIMB_ID"), 
					rs.getDouble("REIMB_AMOUNT"),
					rs.getTimestamp("REIMB_SUBMITTED"),
					rs.getTimestamp("REIMB_RESOLVED"),
					rs.getString("REIMB_DESCRIPTION"),
					rs.getBlob("REIMB_RECEIPT"),
					author, 
					resolver,
					rs.getInt("REIMB_STATUS_ID"), 
					rs.getInt("REIMB_TYPE_ID"), 
					status, 
					type));
		}

		return allReimbList;
	}

	public List<Reimbursements> getFilteredReimbursements(int status) throws SQLException {
		String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_STATUS_ID = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, status);
		stmt.executeQuery();

		ResultSet rs = stmt.executeQuery();
		List<Reimbursements> reimbByStatus = new ArrayList<Reimbursements>();

		while (rs.next()) {

			ReimbursementsType type = getType(rs.getInt("REIMB_TYPE_ID"));
			ReimbursementsStatus statusid = getStatus(rs.getInt("REIMB_STATUS_ID"));

			User author = new UserDAOImple(conn).getUserbyID(rs.getInt("REIMB_AUTHOR"));
			User resolver = new UserDAOImple(conn).getUserbyID(rs.getInt("REIMB_RESOLVER"));

			reimbByStatus.add(new Reimbursements(rs.getInt("REIMB_ID"), rs.getDouble("REIMB_AMOUNT"),
					rs.getTimestamp("REIMB_SUBMITTED"), rs.getTimestamp("REIMB_RESOLVED"),
					rs.getString("REIMB_DESCRIPTION"), rs.getBlob("REIMB_RECEIPT"), author, resolver,
					rs.getInt("REIMB_STATUS_ID"), rs.getInt("REIMB_TYPE_ID"), statusid, type));
		}

		return reimbByStatus;
	}

	public void updateReimbursementsStatus(int resID, int reimbID, int status) throws SQLException {
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());

		String sql = "UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID = ?, REIMB_RESOLVED = ?, REIMB_RESOLVER = ? WHERE REIMB_ID = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, status);
		stmt.setTimestamp(2, time);
		stmt.setInt(3, resID);
		stmt.setInt(4, reimbID);
		stmt.executeUpdate();

	}

	public ReimbursementsStatus getStatus(int statusID) throws SQLException {
		ReimbursementsStatus status = new ReimbursementsStatus();

		String sql = "SELECT * FROM ERS_REIMBURSEMENT_STATUS WHERE REIMB_STATUS_ID = ?";

		PreparedStatement stmt;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, statusID);
			stmt.executeQuery();

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				status.setStatusID(rs.getInt("REIMB_STATUS_ID"));
				status.setStatus(rs.getString("REIMB_STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	public ReimbursementsType getType(int typeID) throws SQLException {
		ReimbursementsType type = new ReimbursementsType();

		String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE WHERE REIMB_TYPE_ID = ?";

		PreparedStatement stmt;

		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, typeID);
		stmt.executeQuery();

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {

			type.setTypeID(rs.getInt("REIMB_TYPE_ID"));
			type.setType(rs.getString("REIMB_TYPE"));
		}

		return type;
	}

}
