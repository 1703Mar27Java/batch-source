package com.revature.dao;

import java.sql.*;
import java.util.*;

import com.revature.domain.*;
import com.revature.util.*;

import oracle.jdbc.OracleTypes;

public class UsersDAOImp implements UsersDAO {

	@Override
	public void createUser(String USER_NAME, String PASSWORD) {
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO USERS (USER_NAME, PASSWORD) VALUES (?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, USER_NAME);
			pstmt.setString(2, PASSWORD);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected + " user added.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public int retrieveUserId(String USER_NAME, String PASSWORD) {
		int user_id = -1;
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT USER_ID FROM USERS WHERE USER_NAME = ? AND PASSWORD = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, USER_NAME);
			pstmt.setString(2, PASSWORD);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				user_id = rs.getInt("USER_ID");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return user_id;
	}

	@Override
	public List<Users> retrieveAllUsers() {
		PreparedStatement pstmt = null;
		List<Users> users = new ArrayList<>();
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String sql = "SELECT * FROM USERS";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String name = rs.getString("USER_NAME");
				String password = rs.getString("PASSWORD");
				Users c = new Users(name,password);
				users.add(c);
			}
		}catch(Exception e){
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
	
	@Override
	public List<Account> retrieveAllAccounts(int uid) {
		List<Account> accounts = new ArrayList<>();
		CallableStatement cs = null;
		ResultSet rs = null;
		try{
			Connection con = ConnectionUtil.getConnection();
			cs = con.prepareCall("{CALL SP_READ_ACCOUNTS(?, ?)}");
			cs.setInt(1, uid);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet) cs.getObject(2);
			while (rs.next()) {
				int bid = rs.getInt("BANK_ACCOUNT_ID");
				int id = rs.getInt("USER_ID");
				String name = rs.getString("BANK_ACCOUNT_NAME");
				int balance = rs.getInt("BALANCE");
				Account c = new Account(id, name, balance);
				c.setBANK_ACCOUNT_ID(bid);
				accounts.add(c);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (cs != null) {
				try {
					cs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return accounts;
	}

	@Override
	public void updateUser(int id, int choice, String updatedStr) {
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE USERS SET USER_NAME = ? WHERE USER_ID = ?";
			switch (choice) {
			case 1: 
				sql = "UPDATE USERS SET USER_NAME = ? WHERE USER_ID = ?"; break;
			case 2:
				sql = "UPDATE USERS SET PASSWORD = ? WHERE USER_ID = ?"; break;
			default: break;
			}
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updatedStr);
			pstmt.setInt(2, id);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected + " user updated.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateAnyUserName(String userName, String newName) {
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String sql = "UPDATE USERS SET USER_NAME = ? WHERE USER_NAME = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newName);
			pstmt.setString(2, userName);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected + " user updated.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateAnyUserPassword(String oldPass, String newPass) {
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String sql = "UPDATE USERS SET PASSWORD = ? WHERE PASSWORD = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPass);
			pstmt.setString(2, oldPass);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected + " user updated.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteAnyUser(String userName) {
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String sql = "DELETE FROM USERS WHERE USER_NAME = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected + " user deleted.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int id) {
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "DELETE FROM USERS WHERE USER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected + " user deleted.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
