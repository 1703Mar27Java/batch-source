package com.revature.dao;

import java.sql.*;
import java.util.List;

import com.revature.domain.Cave;
import com.revature.util.ConnectionUtil;

public class CaveDAOImpl implements CaveDAO {

	@Override
	public void createCave(Cave cave) {
		// TODO Auto-generated method stub
		try(Connection con =ConnectionUtil.getConnection();){
			
			
			
			//we're autoGenerating out pks in the database because we're not bararians
			String n=cave.getName();
			int m=cave.getMaxBears();
			
			String sql="INSERT INTO CAVE(CAVE_NAME,MAX_BEARS) VALUES("+n+"',"+m+")";
			
			int id=cave.getId();
			 n=cave.getName();
		 m=cave.getMaxBears();
			
			sql="INSERT INTO CAVE VALUES("+id+",'"+n+"',"+m+")";
			
			Statement statement= con.createStatement();
			int numRowsAffected= statement.executeUpdate(sql);
			System.out.println(numRowsAffected);
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public Cave retrieveCaveById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cave> retrieveAllCaves() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCave(Cave cave) {
		try {
			Connection con=ConnectionUtil.getConnection();
			
			int i=cave.getId();
			String n=cave.getName();
			int m=cave.getMaxBears();
			
			String sql="UPDATE CAVE SET CAVE_NAME= '"+n+"' SET MAX_BEARS="+m+" WHERE CAVE_ID="+i+";";
			
			PreparedStatement pstmt=con.prepareStatement(sql);
			System.out.println(sql);
			System.out.println(pstmt.executeUpdate());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCave(int id) {
		try {
			Connection con=ConnectionUtil.getConnection();
			
			
			
			String sql="DELETE * FROM CAVE WHERE CAVE_ID= '"+id+"'";
			
			PreparedStatement pstmt=con.prepareStatement(sql);
			
			System.out.println(pstmt.executeUpdate());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void createCavePS(Cave cave){
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String n=cave.getName();
			int m=cave.getMaxBears();
			String sql = "INSERT INTO CAVE (CAVE_NAME,MAX_BEARS) VALUES ('?',?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n);
			pstmt.setInt(2, m);
			int numRowsAffected=pstmt.executeUpdate();
			System.out.println(numRowsAffected);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	
}
