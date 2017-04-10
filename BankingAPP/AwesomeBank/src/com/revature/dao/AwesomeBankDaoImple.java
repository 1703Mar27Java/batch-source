package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.AwesomeBank;
import com.revature.util.ConnectionUtil;

public class AwesomeBankDaoImple implements AwesomeBankDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int createAccount(AwesomeBank awesome) {
		// TODO Auto-generated method stub
		try(Connection con = ConnectionUtil.getConnection();){
			String name = awesome.getAccountName();
			String pass = awesome.getPassword();
			
			String sql = "INSERT INTO BANK_USER (USER_NAME,USER_PASSWORD) VALUES(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pass);
			int numRowsAffected = pstmt.executeUpdate();
			if(numRowsAffected ==1)
			{
				System.out.println("=====================\n"+"ACCOUNT CREATED");
			}
			
			return numRowsAffected;
		}catch(SQLException e)
		{
			System.out.println("=====================\n"+"SOMEONE ALREADY HAS THAT AWESOME USERNAME AND PASSWORD PLEASE TRY AGAIN");
			//e.printStackTrace();
			return 0 ;
		}
	
	}

	@Override
	public void updateAccount(AwesomeBank acc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createPassword(AwesomeBank acc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(int accID){
		// TODO Auto-generated method stub
	try{
			
			Connection con = ConnectionUtil.getConnection();
			System.out.println(con.toString());
			String sql = "DELETE FROM BANK_USER WHERE USER_ID = ?";
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
	public AwesomeBank retrieveAccountByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AwesomeBank viewAccount(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AwesomeBank> retieveAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getAccountBalance(AwesomeBank acc) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void depositMoney(AwesomeBank acc, float amount) {
		// TODO Auto-generated method stub
		
		CallableStatement cs = null;
		try{
			
			int accID = acc.getAccID();
			
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			cs = con.prepareCall("{call SP_DEPOSIT(?,?)}");
			cs.setInt(1, accID);
			cs.setFloat(2, amount);
			boolean numRowsaffected = cs.execute();
			if(numRowsaffected)
			{
				System.out.println("=====================\n"+"YOUR DEPOSIT HAS BEEN APPROVED");
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void withdrawMoney(AwesomeBank acc, float amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout(AwesomeBank acc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login(AwesomeBank acc) {
		// TODO Auto-generated method stub
		
	}

}
