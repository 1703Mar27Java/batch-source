package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.AwesomeBank;
import com.revature.domain.AwesomeBankUser;
import com.revature.util.ConnectionUtil;
import com.sun.xml.internal.ws.wsdl.writer.document.Types;

public class AwesomeBankDaoImple implements AwesomeBankDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createAccount(String accName, int id) {
		// TODO Auto-generated method stub
		try(Connection con = ConnectionUtil.getConnection();){
			String name = accName;
			
			String sql = "INSERT INTO BANK_ACCOUNT (USER_ID,BANK_ACCOUNT_NAME, BALANCE) VALUES(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, 0);
			int numRowsAffected = pstmt.executeUpdate();
			if(numRowsAffected ==1)
			{
				System.out.println("=====================\n"+"ACCOUNT CREATED");
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			//System.out.println("=====================\n"+"SOMEONE ALREADY HAS THAT AWESOME USERNAME AND PASSWORD PLEASE TRY AGAIN");
			
		}
	
	}

	@Override
	public void updateAccount(int id, String update) {
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE BANK_ACCOUNT SET BANK_ACCOUNT_NAME = ? WHERE BANK_ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, update);
			pstmt.setInt(2, id);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected + " user updated.");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void deleteAccount(int accID){
		// TODO Auto-generated method stub
	try{
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println(con.toString());
			String sql = "DELETE FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accID);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected);
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public int retrieveAccountByID(int id, String name) {
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT BANK_ACCOUNT_ID FROM BANK_ACCOUNT "+ "WHERE USER_ID = ? AND BANK_ACCOUNT_NAME = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				id = rs.getInt("BANK_ACCOUNT_ID");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return id;
	}



	@Override
	public AwesomeBank viewAccount(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(String name, String pass) {
		// TODO Auto-generated method stub
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO BANK_USER (USER_NAME, USER_PASSWORD) VALUES (?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected + " user added.");
			
			
		}catch (SQLException ex) {
			System.out.println("SOMEONE AWESOME IS ALREADY USING " +name +" AS A USERNAME");
			ex.printStackTrace();
					
		}
	}

	@Override
	public int retriveUserbyID(String name, String pass) {
		// TODO Auto-generated method stub
		int user_id = -1;
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT USER_ID FROM BANK_USER WHERE USER_NAME = ? AND USER_PASSWORD = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				user_id = rs.getInt("USER_ID");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return user_id;
	}

	@Override
	public List<AwesomeBankUser> retriveUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AwesomeBank> retriveAccounts(int id) {
		PreparedStatement pstmt = null;
		List<AwesomeBank> accounts = new ArrayList<>();
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int bid = rs.getInt("BANK_ACCOUNTID");
				int ids = rs.getInt("USER_ID");
				String name = rs.getString("BANK_ACCOUNT_NAME");
				int balance = rs.getInt("BALANCE");
				AwesomeBank c = new AwesomeBank(ids, name, balance);
				c.setAccID(bid);
				accounts.add(c);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public void updateU(int id, int choice, String update) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBalance(int id, int uBalance) {
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE BANK_ACCOUNT SET BALANCE = ? WHERE BANK_ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, uBalance);
			pstmt.setInt(2, id);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected + " user updated.");
		}catch (SQLException ex) {
			
		}
		
	}

	@Override
	public String logIn(String name, String pass) {
		
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql= "BEGIN SP_VALIDATE_USER(?,?,?);END;";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setString(1, name);
			cstmt.setString(2, pass);
			cstmt.registerOutParameter(3,java.sql.Types.INTEGER);
			cstmt.execute();
			int valid = cstmt.getInt(3);
			if(valid == 1)
				return name;
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public void withdraw(int id, int with) {
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE BANK_ACCOUNT SET BALANCE = BALANCE-? WHERE BANK_ACCOUNTID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, with);
			pstmt.setInt(2, id);
			int numRowsAffected = pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deposit(int id, int depo) {
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "UPDATE BANK_ACCOUNT SET BALANCE = BALANCE+? WHERE BANK_ACCOUNTID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, depo);
			pstmt.setInt(2, id);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println(numRowsAffected);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}

}
