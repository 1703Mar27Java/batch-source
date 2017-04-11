package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.domain.BankAccount;
import com.revature.domain.Cave;
import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

import java.sql.*;

public class BankAccountDaoImpl implements BankAccountDao {

	@Override
	public void createAccount(BankAccount account) {
		try(Connection con = ConnectionUtil.getConnection()){
			//we're autogenerating out pks u in the database because we're not barbarians
			int uID = account.getUserID();
			//int bankID = account.getBank_account_name();
			String  name = account.getBank_account_name();
			double balance = account.getBalance();
			
			String sql = "INSERT INTO BANKACCOUNT (AccountName, Balance, UserID) VALUES ('"+name+"', '"+balance+"', '"+uID+"')";
			
			Statement statement = con.createStatement();	//this is precompiled
			int numRowsAffected = statement.executeUpdate(sql);	//this argument is not precompiled as a paramater
			System.out.println("hi");							//use prepared statements to prevent sql injections by users
			
			
		} catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public BankAccount retrieveAccountById(int userId) {
		PreparedStatement pstmt = null;
		BankAccount bankAcct = null;
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANKACCOUNT WHERE USERID = '" + userId +"'";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int acctId = rs.getInt("ACCOUNTID");
				String acctName = rs.getString("ACCOUNTNAME");
				double acctBalance = rs.getDouble("BALANCE");
				int userID = rs.getInt("USERID");
				bankAcct = new BankAccount(acctName, acctBalance, userID);
				bankAcct.setBank_accountID(acctId);
				break;
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
		return bankAcct;
	}
	
	public BankAccount retrieveAccountByAcctId(int accountId){
		PreparedStatement pstmt = null;
		BankAccount bankAcct = null;
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANKACCOUNT WHERE ACCOUNTID = '" + accountId +"'";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int acctId = rs.getInt("ACCOUNTID");
				String acctName = rs.getString("ACCOUNTNAME");
				double acctBalance = rs.getDouble("BALANCE");
				int userID = rs.getInt("USERID");
				bankAcct = new BankAccount(acctName, acctBalance, userID);
				bankAcct.setBank_accountID(acctId);
				break;
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
		return bankAcct;
	}

	@Override
	public List<BankAccount> retrieveAllAccount() {
		PreparedStatement pstmt = null;
		List<BankAccount> accounts = new ArrayList<>();
		try{
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM BANKACCOUNT";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int acctId = rs.getInt("ACCOUNTID");
				String acctName = rs.getString("ACCOUNTNAME");
				double acctBalance = rs.getDouble("BALANCE");
				int userID = rs.getInt("USERID");
				BankAccount bankAcct = new BankAccount(acctName, acctBalance, userID);
				bankAcct.setBank_accountID(acctId);
				accounts.add(bankAcct);
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
		return accounts;
	}

	@Override
	public void updateAccount(BankAccount account, String action, double depAmt) {
		PreparedStatement pstmt = null;
		switch (action){
			case "WITHDRAW":
				try{
					Connection con = ConnectionUtil.getConnection();
					String sql = "UPDATE BANKACCOUNT SET BALANCE = BALANCE - '" + depAmt + "' WHERE ACCOUNTID = + '" + account.getBank_account_id() +"'";
					pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
				}catch(SQLException e){
					e.printStackTrace();
				}finally{
					if (pstmt!=null){
						try {
							pstmt.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
				break;
			case "DEPOSIT":
				try{
					Connection con = ConnectionUtil.getConnection();
					String sql = "UPDATE BANKACCOUNT SET BALANCE = BALANCE + '" + depAmt + "' WHERE ACCOUNTID = + '" + account.getBank_account_id() +"'";
					pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					System.out.println(account.getBank_account_id());
				}catch(SQLException e){
					e.printStackTrace();
				}finally{
					if (pstmt!=null){
						try {
							pstmt.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
				break;
		}
	}

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void createAccountPS(BankAccount account) {
		// TODO Auto-generated method stub
		
	}
	
	public void switchAccount(int acctId, int usrId){
		
	}
	
}
