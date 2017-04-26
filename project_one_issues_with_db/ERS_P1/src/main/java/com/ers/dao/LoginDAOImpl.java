package com.ers.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.ers.domain.Login;
import com.ers.util.ERSUtil;

public class LoginDAOImpl {

	
		public void createEmpUser(Login log){
			try{
				Connection con = ERSUtil.getConnectionFromFile();
				 int l = log.getLid();
				 String r = log.getRole();
				 
				
				String sql = "INSERT INTO ERS_USER_ROLES VALUES (?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, l);
				pstmt.setString(2, r);
				int numRowsAffected = pstmt.executeUpdate();
				System.out.println(numRowsAffected);
				
			}catch(SQLException|IOException  e){
				e.printStackTrace();
				
			}	
			
		}
	}

