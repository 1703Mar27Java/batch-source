package com.pbjbank.dao;

import com.pbjbank.domain.User_Logon;
import com.pbjbank.util.ConnectionUtil;

import java.io.IOException;
import java.sql.*;
import java.util.*;



public class BankUserDAOImpl implements BankUserDAO {

	
/*	public void createNewUser(User_Logon userLogon) {
		try{	 
			Connection con = ConnectionUtil.getConnection(); 
			int u = userLogon.getuserID();
			String n = userLogon.getUserName();
			String p = userLogon.getPassword();
			
			
			String sql = "INSERT INTO USER_LOGON (USER_ID, USER_NAME,PASSWORD) VALUES ('"+u+"','"+n+"','"+p+"')";
			
			Statement statement = con.createStatement();
			int numRowsAffected = statement.executeUpdate(sql);
			System.out.println(numRowsAffected);
			
		} catch (SQLException e){
			e.printStackTrace();
		}

	}*/

	
	public void createNewUserPS(User_Logon userLogon) {

		try{
			Connection con = ConnectionUtil.getConnectionFromFile();
			int u = userLogon.getuserID();
			String n = userLogon.getUserName();
			String p = userLogon.getPassword();
			String sql = "INSERT INTO USER_LOGON VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, u);
			pstmt.setString(2, n);
			pstmt.setString(3, p);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected);
			
		}catch(SQLException | IOException e){
			e.printStackTrace();
		}

	}

	public void  retrieveUserName(String userName, String password) {
		try{
			Connection con = ConnectionUtil.getConnectionFromFile();		
			String sql = "SELECT USER_NAME FROM USER_LOGON WHERE USER_NAME = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString("USER_NAME");
				System.out.print(name);		
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<User_Logon> retrieveAllUser_Logons() {
		PreparedStatement pstmt = null;
		List<User_Logon> users = new ArrayList<>();
		try{
			Connection con = ConnectionUtil.getConnectionFromFile();
			String sql = "SELECT * FROM USER_LOGON";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("USER_ID");
				String name = rs.getString("USER_NAME");
				String pass = rs.getString("PASSWORD");
				User_Logon c = new User_Logon(id,name,pass);
				users.add(c);
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (pstmt!=null){try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			
		}
		return users;
	}

	public void updateUser(User_Logon userLogon) {

		try{
			Connection con = ConnectionUtil.getConnectionFromFile();		
			String sql = "UPDATE USER_LOGON SET USER_NAME =:new.USER_NAME WHERE USER_NAME=:old.USER_NAME";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString("USER_NAME");
				System.out.print(name);		
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
		

	}

	public void deleteUser(String userName) {

		try{
			Connection con = ConnectionUtil.getConnectionFromFile();		
			String sql = "DELETE FROM USER_LOGON WHERE USER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString("USER_NAME");
				System.out.print(name);		
			}
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
		

	}

}
