package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Reimbursement;
import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public void createReimbursement(Reimbursement rei) {
		try(Connection con = ConnectionUtil.getConnection()){
			//we're autogenerating out pks u in the database because we're not barbarians
			int authID = rei.getAuthor();
			int typ = rei.getrTtype();
			int stat = rei.getrTstatus();
			double amt = rei.getAmt();
			String desc = rei.getDesc();
			//String receipt = rei.getReceipt();
			
			String sql = "INSERT INTO ERS_REIMBURSEMENTS (R_AMOUNT, R_DESCRIPTION, U_ID_AUTHOR, RT_TYPE, RS_STATUS) VALUES ('"+amt+"', '"+desc+"','"+authID+"','"+typ+"','"+stat+"')";
			
			System.out.println("you's on da bluegrass 1!");
			
			Statement statement = con.createStatement();	//this is precompiled
			int numRowsAffected = statement.executeUpdate(sql);	//this argument is not precompiled as a paramater
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public Reimbursement retrieveReimbursementById(int rid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Reimbursement> retrieveUserReimbursementByUserId(int uid) {
		PreparedStatement pstmt = null;
		List<Reimbursement> reims = new ArrayList<>();
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR IN ('"+uid+"')";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int rID = rs.getInt("R_ID");
				int amt = rs.getInt("R_AMOUNT");
				String desc = rs.getString("R_DESCRIPTION");
				int typ = rs.getInt("RT_TYPE");
				int status = rs.getInt("RS_STATUS");
				
				Reimbursement r = new Reimbursement(uid);
				r.setrID(rID);
				r.setAmt(amt);
				r.setDesc(desc);
				r.setAuthor(uid);
				r.setrTtype(typ);
				r.setrTstatus(status);
				reims.add(r);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if (pstmt!=null){try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
		}
		return reims;

	}

	@Override
	public List<Reimbursement> retrieveReimbursements() {
		PreparedStatement pstmt = null;
		List<Reimbursement> reims = new ArrayList<>();
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int rID = rs.getInt("R_ID");
				int amt = rs.getInt("R_AMOUNT");
				String desc = rs.getString("R_DESCRIPTION");
				int typ = rs.getInt("RT_TYPE");
				int status = rs.getInt("RS_STATUS");
				int uid = rs.getInt("U_ID_AUTHOR");
				
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String submitted  = dateFormat.format(rs.getTimestamp("R_SUBMITTED"));
				
				System.out.println(submitted);
				
				Reimbursement r = new Reimbursement(uid);
				r.setrID(rID);
				r.setAmt(amt);
				r.setDesc(desc);
				r.setAuthor(uid);
				r.setrTtype(typ);
				r.setrTstatus(status);
				r.setSubmitted(submitted);
				reims.add(r);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if (pstmt!=null){try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
		}
		return reims;
	}

	@Override
	public void updateReimbursement(Reimbursement rei, String un, String fName, String lName, String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteReimbursement(int id) {
		// TODO Auto-generated method stub

	}

}
