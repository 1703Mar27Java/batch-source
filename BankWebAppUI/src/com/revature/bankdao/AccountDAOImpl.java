package com.revature.bankdao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.butil.ConnectionBankUtil;
import com.revature.domain.Account;
import com.revature.domain.Bank;

import oracle.jdbc.OracleTypes;

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
	public Account retrieveAccountID(int id) {
		CallableStatement cs = null;
		Account acct = new Account();
		
		try{
			Connection con = ConnectionBankUtil.getConnection();
			cs = con.prepareCall("{call RETRIEVE_ACCOUNT(?,?)}");
			cs.setInt(1, id);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs = (ResultSet) cs.getObject(2);
			while(rs.next()){
				acct.setAccountid(rs.getInt("BANK_ACCOUNTID"));
				acct.setAccount_name(rs.getString("BANK_ACCOUNT_NAME"));
				acct.setBalance(rs.getDouble("BALANCE"));
				acct.setId(rs.getInt("USER_ID"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		} 
		return acct;
	}
	
	@Override
	public void createAccount(Account acct) {
		try  {
			Connection con = ConnectionBankUtil.getConnection();
	
			String n = acct.getAccount_name();
			int id = acct.getId();
			//double b = acct.getBalance();
			
			String sql = "INSERT INTO BANKACCOUNT (BANK_ACCOUNT_NAME, BALANCE, USER_ID)" + "VALUES (?, ?, "+id+")";
			//String sql = "{Call CREATE_ACCOUNT(?,0,?)}";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, n);
			pstmt.setDouble(2, 0);
			//pstmt.setInt(2, id);

			pstmt.executeUpdate();
			
	}catch (SQLException e) {
		e.printStackTrace();
	}
	}
}
