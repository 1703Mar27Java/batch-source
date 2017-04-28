package com.ers.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ers.domain.Reimbursements;
import com.ers.util.ERSUtil;

public class ReimbursementsDAOImpl implements ReimbursementsDAO {

	@Override
	public void submitReimbursements(Reimbursements re) {
		try{
			Connection con = ERSUtil.getConnectionFromFile();
		//	 int rid = re.getRid();
			 double amt = re.getAmt();
			 String desc = re.getDesc();
		//	 String receipt = re.getReceipt();
		//	 String timestamp = re.getTimestamp();
		//	 int author = re.getAuthor();
		//	 int resolved = re.getResolved();
		//	 int type = re.getType();
		//	 int  status = re.getStatus();
			 
			
			String sql = "INSERT INTO ERS_REIMBURSEMENTS VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
		//	pstmt.setInt(1, l);
			pstmt.setDouble(1, amt);
			pstmt.setString(2, desc);
		//	pstmt.setString(4, r);
		//	pstmt.setString(5, l);
		//	pstmt.setInt(6, r);
		//	pstmt.setInt(7, l);
		//	pstmt.setInt(8, r);
		//	pstmt.setInt(9, l);
		
			
			
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected);
			
		}catch(SQLException|IOException  e){
			e.printStackTrace();
			
		}	
		
	}
		
	}

	


