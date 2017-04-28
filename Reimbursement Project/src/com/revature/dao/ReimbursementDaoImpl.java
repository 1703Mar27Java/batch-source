package com.revature.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.revature.domain.Employee;
import com.revature.domain.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public void createReimbursement(Employee employee, Reimbursement reimbursement, InputStream input) {
		try {
			Connection con = ConnectionUtil.getConnection();

			String sql = "INSERT INTO ERS_REIMBURSEMENTS "
					+ "(R_AMOUNT, R_DESCRIPTION, R_RECEIPT, R_SUBMITTED, U_ID_AUTHOR, RT_TYPE, RS_STATUS, R_FILENAME) " + "VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reimbursement.getReimbursementAmount());
			pstmt.setString(2, reimbursement.getReimbursementDescription());
			if (input != null)
				pstmt.setBlob(3, input);
			
			pstmt.setTimestamp(4, Timestamp.valueOf(reimbursement.getReimbursementSubmitDate()));
			pstmt.setInt(5, employee.getEmployeeID());

			switch (reimbursement.getReimbursementType()) {
			case Rent:
				pstmt.setInt(6, 1);
				break;
			case Gas:
				pstmt.setInt(6, 2);
				break;
			case Books:
				pstmt.setInt(6, 3);
				break;
			case Tech:
				pstmt.setInt(6, 4);
				break;
			case Food:
				pstmt.setInt(6, 5);
				break;
			case Travel:
				pstmt.setInt(6, 6);
				break;
			default:
				break;
			}
			
			switch(reimbursement.getReimbursementStatus())
			{
			case Pending:
				pstmt.setInt(7, 1);
				break;
			case Approved:
				pstmt.setInt(7, 2);
				break;
			case Declined:
				pstmt.setInt(7, 3);
				break;
			case New:
				pstmt.setInt(7, 4);
				break;
			default:
				break;
			
			}
			
			pstmt.setString(8, reimbursement.getReimbursementReceipt());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void retreiveReimbursementById(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateReimbursement(Reimbursement reimbursement, int Resovler) {
		try {
			Connection con = ConnectionUtil.getConnection();

			String sql = "UPDATE ERS_REIMBURSEMENTS SET RS_STATUS = (?), R_RESOLVED = (?), U_ID_RESOLVER = (?) WHERE R_ID = (?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			switch(reimbursement.getReimbursementStatus())
			{
			case Pending:
				pstmt.setInt(1, 1);
				break;
			case Approved:
				pstmt.setInt(1, 2);
				break;
			case Declined:
				pstmt.setInt(1, 3);
				break;
			case New:
				pstmt.setInt(1, 4);
				break;
			default:
				break;
			
			}
			pstmt.setTimestamp(2, Timestamp.valueOf(reimbursement.getReimbursementResolveDate()));
			pstmt.setInt(3, reimbursement.getEmployeeResolver());
			pstmt.setInt(4, Resovler);

			System.out.println(pstmt.executeUpdate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}