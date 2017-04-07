package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Cave;
import com.revature.util.ConnectionUtil;

public class CaveDAOImpl implements CaveDAO {

	@Override
	public void createCave(Cave cave) {
		try(Connection con = ConnectionUtil.getConnection();) {
			
			//we're autogenerating out PKs in the database
			//because we're not barbarians 
			String n = cave.getName();
			int m = cave.getMaxBears();
			
			String sql = "INSERT INTO CAVE (CAVE_NAME,MAX_BEARS) VALUES ('"+n+"',"+m+")";
			
			Statement statement = con.createStatement();
			int numRowsAffected = statement.executeUpdate(sql);
			System.out.println(numRowsAffected);
			
		} catch (SQLException e){
			e.printStackTrace();
		}

	}
	
	@Override
	public void createCavePS(Cave cave) {
		try{
			Connection con = ConnectionUtil.getConnection();
			String n = cave.getName();
			int m = cave.getMaxBears();
			String sql = "INSERT INTO CAVE (CAVE_NAME,MAX_BEARS) VALUES (?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, n);
			pstmt.setInt(2, m);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected);
		}catch(SQLException e){
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
		PreparedStatement pstmt = null;
		List<Cave> caves = new ArrayList<>();
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM CAVE";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("CAVE_ID");
				String name = rs.getString("CAVE_NAME");
				int maxBears = rs.getInt("MAX_BEARS");
				Cave c = new Cave(id,name,maxBears);
				caves.add(c);
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
		return caves;
	}

	@Override
	public void updateCave(Cave cave) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCave(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeHelloWorld() {
		CallableStatement cs = null;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			cs = con.prepareCall("{call HELLO_WORLD_PROCEDURE(?)");
			cs.registerOutParameter(1, java.sql.Types.VARCHAR);
			cs.execute();
			System.out.println(cs.getString(1));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}



}
