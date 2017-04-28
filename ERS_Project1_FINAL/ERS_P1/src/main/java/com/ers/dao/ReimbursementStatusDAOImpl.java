package com.ers.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ers.domain.ReimbursementStatus;
import com.ers.util.ERSUtil;

public class ReimbursementStatusDAOImpl implements ReimbursementStatusDAO {

	@Override
	public void enterStatus(ReimbursementStatus status) {
		try{
			Connection con = ERSUtil.getConnectionFromFile();
			 int rsid = status.getRs_id();
			 String s = status.getRs_status();
		
			
			String sql = "INSERT INTO ERS_REIMBURSEMENTS VALUES (?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rsid);
			pstmt.setString(1, s);
			
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected);
			
		}catch(SQLException|IOException  e){
			e.printStackTrace();
			
		}	
		
		
	}

	@Override
	public void retrieveStatus(ReimbursementStatus status) {
		// TODO Auto-generated method stub
		
	}



}
