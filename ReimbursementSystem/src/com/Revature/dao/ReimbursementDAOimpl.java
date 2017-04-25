package com.Revature.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.Revature.domain.Reimbursement;
import com.Revature.util.ConnectionUtil;

public class ReimbursementDAOimpl implements ReimbursementDAO {
	@Override
	public void createReimbursement(Reimbursement reimb) {
		/*CREATE_REIMBURSEMENT(AMT IN NUMBER, DESCRIPT IN VARCHAR2, RECEIPT IN BLOB, 
				SUBMIT IN TIMESTAMP, AUTHORID IN NUMBER, RTID IN NUMBER, RSID IN NUMBER)*/
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");) {
			double amount = reimb.getAmount();
			String desc = reimb.getDescription();
			InputStream receipt = reimb.getReceipt();
			Timestamp timestamp = reimb.getTimestamp();
			int uid = reimb.getId();
			int rtid = reimb.getTypeID();
			PreparedStatement cs = con.prepareStatement("{call CREATE_REIMBURSEMENT(?,?,?,?,?,?,1)}"); //1 is unresolved status id
			cs.setDouble(1, amount);
			cs.setString(2, desc);
		    cs.setBlob(3, receipt);
			cs.setTimestamp(4, timestamp);
			cs.setInt(5, uid);
			cs.setInt(6, rtid);
			int numRowsAffected = cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public List<Reimbursement> filter(int userid, String filterType) {
		switch(filterType){
		case "resolved":break;
		case "unresolved": break;
		}
		return null;
	}

	@Override
	public List<Reimbursement> unresolved(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> resolved(int userid) {
		// TODO Auto-generated method stub
		return null;
	}


}
