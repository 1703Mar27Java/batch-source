package com.revature.dao;

import java.sql.*;
import java.util.*;

import com.revature.domain.Account;
import com.revature.util.ConnectionUtil;

public class AccountDAOImp implements AccountDAO {

	@Override
	public void createAccount(int id, String name) {
		try{
			Connection con = ConnectionUtil.getConnection();
			String n = name;
			String sql = "INSERT INTO BANK_ACCOUNT (USER_ID, BANK_ACCOUNT_NAME, BALANCE) "
					+ "VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, n);
			pstmt.setInt(3, 0);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected + " account added.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public int retrieveAccountId(int userId, String accName) {
		int accId = -1;
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT BANK_ACCOUNT_ID FROM BANK_ACCOUNT "
					+ "WHERE USER_ID = ? AND BANK_ACCOUNT_NAME = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setString(2, accName);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				accId = rs.getInt("BANK_ACCOUNT_ID");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return accId;
	}

	@Override
	public List<Account> retrieveAllAccounts(int uid) {
		PreparedStatement pstmt = null;
		List<Account> accounts = new ArrayList<>();
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, uid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
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
		}finally{
			if (pstmt!=null){try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}}
		}
		return accounts;
	}

	@Override
	public void updateAccount(int id, String updatedStr) {
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE BANK_ACCOUNT SET BANK_ACCOUNT_NAME = ? WHERE BANK_ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, updatedStr);
			pstmt.setInt(2, id);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected + " user updated.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateBalance(int id, int updatedBal) {
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE BANK_ACCOUNT SET BALANCE = ? WHERE BANK_ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, updatedBal);
			pstmt.setInt(2, id);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected + " user updated.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAccount(int id) {
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "DELETE FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected + " account deleted.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}