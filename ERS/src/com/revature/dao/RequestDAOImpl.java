package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;

import com.revature.bean.Request;

import com.revature.util.ConnectionUtil;

public class RequestDAOImpl implements RequestDAO {

	@Override
	public ArrayList<Request> fetchReqs(String uName) {
		ArrayList<Request> rList = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection();) {

			String sql = "SELECT * FROM VW_ERS_REIMBURSEMENTS WHERE USERNAME=?";
			PreparedStatement pstmt = con.prepareCall(sql);
			pstmt.setString(1, uName);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int r_id;
				Timestamp tS, tR;
				String descr, type, status, username, firstName, lastName;
				double amount;
				r_id = rs.getInt("R_ID");
				descr = rs.getString("DESCRIPTION");
				tS = rs.getTimestamp("TIME_RESOLVED");
				tR = rs.getTimestamp("TIME_SUBMITTED");
				amount = rs.getDouble("AMOUNT");
				type = rs.getString("R_TYPE");
				status = rs.getString("R_STATUS");
				username = rs.getString("USERNAME");
				firstName = rs.getString("FIRST_NAME");
				lastName = rs.getString("LAST_NAME");

				Request r = new Request(r_id, descr, tS, tR, type, status, username, firstName, lastName, amount);
				System.out.println(r);
				rList.add(r);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rList;
	}

	@Override
	public void createReq(String descr, double amt, String uName, String rType) {
		try (Connection con = ConnectionUtil.getConnection();) {
			String sql = "BEGIN ERS_SP_CREATE_REIMBUR_DESCR (?,?,?,?,?); END;";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setString(1, descr);
			cstmt.setDouble(2, amt);
			cstmt.setString(3, uName);
			cstmt.setString(4, rType);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//todo fix this update sp
	
	// SP_ERS_RESOLVE_REIMBURS(IN_ID IN NUMBER, STATUS IN VARCHAR, RESOLVED_BY
	// IN VARCHAR, TEXT_OUT OUT VARCHAR)
	@Override
	public void resolveReq(int rid, String status, String mgr) {
		try (Connection con = ConnectionUtil.getConnection();) {
			String sql = "BEGIN SP_ERS_RESOLVE_REIMBURS(?, ?, ?, ?); END;";
			CallableStatement cstmt = con.prepareCall(sql);
			String txtOut = "";
			if (status.equals("Approve"))
				status = "Approved";
			else if (status.equals("Deny"))
				status = "Denied";
			if (!status.equals("No Change")) {
				cstmt.setInt(1, rid);
				cstmt.setString(2, status);
				cstmt.setString(3, mgr);
				cstmt.registerOutParameter(4, Types.VARCHAR);
				cstmt.execute();
				txtOut = cstmt.getString(4);
				System.out.println(txtOut);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
