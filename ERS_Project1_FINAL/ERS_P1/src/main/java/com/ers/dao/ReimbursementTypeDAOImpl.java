package com.ers.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ers.domain.ReimbursementType;
import com.ers.util.ERSUtil;

public class ReimbursementTypeDAOImpl implements ReimbursementTypeDAO {

	@Override
	public void retrieveType(ReimbursementType type) {
		
		
	}

	@Override
	public void enterTypeInfo(ReimbursementType type) {
		// TODO Auto-generated method stub
		try{
			Connection con = ERSUtil.getConnectionFromFile();
			int rt_id = type.getRt_id();
			String t = type.getType();
			
			String sql = "INSERT INTO ERS_USERS VALUES (?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rt_id);
			pstmt.setString(2, t);
			
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected);
			
		}catch(SQLException|IOException  e){
			e.printStackTrace();
			
		}	
		
		
	}

	
}
