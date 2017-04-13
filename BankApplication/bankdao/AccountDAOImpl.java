package com.revature.bankdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.butil.ConnectionBankUtil;
import com.revature.domain.Account;

public class AccountDAOImpl implements AccountDAO{

	@Override
	public void Deposit(int id, int money) {
		try 
		{
			Connection con = ConnectionBankUtil.getConnection();
			String sql = "UPDATE BANKACCOUNT SET BALANCE = BALANCE +" + money + " WHERE BANK_ACCOUNTID = " + id;
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
		}catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		
	}

	@Override
	public void Withdraw(int id, int money) {
		try 
		{
			Connection con = ConnectionBankUtil.getConnection();
			String sql = "UPDATE BANKACCOUNT SET BALANCE = BALANCE -" + money + " WHERE BANK_ACCOUNTID = " + id;
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
		}catch (SQLException e) 
		{
			e.printStackTrace();
		} 
	}

	@Override
	public void Balance(int money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteAccount(int id) {
		try 
		{
			Connection con = ConnectionBankUtil.getConnection();
			String sql = "DELETE FROM BANKACCOUNT WHERE BANK_ACCOUNTID = "+ id;
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		
	}

	@Override
	public void createAccount(Account acct) {
		try  {
			Connection con = ConnectionBankUtil.getConnection();
	
			String n = acct.getAccount_name();
			int id = acct.getId();
			
			String sql = "INSERT INTO BANKACCOUNT (BANK_ACCOUNT_NAME, BALANCE, USER_ID)"
					+ "VALUES (?, ?, "+id+")";

			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, n);
			pstmt.setInt(2, 0);
			pstmt.setInt(3, id);

			pstmt.executeUpdate();
			
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}
}
