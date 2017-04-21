package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.domain.Cave;
import com.revature.util.ConnectionUtil;

public class CaveDAOImpl {
	

	public void createCavePS(Cave cave) {
		Connection con = null;
		try{
			con = ConnectionUtil.getConnection();
			
			con.setAutoCommit(false);
			
			String n = cave.getName();
			int m = cave.getMaxBears();
			String sql = "INSERT INTO CAVE (CAVE_NAME,MAX_BEARS) VALUES (?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n);
			pstmt.setInt(2, m);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected);
			
			con.commit();
		}catch(SQLException e){
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
		
}
