package com.revature.BankAssignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.BankAssignment.domain.BankAccount;
import com.revature.BankAssignment.domain.User;
import com.revature.BankAssignment.util.ConnectionUtil;

public class BankDAOImpl implements BankDAO {

	public void ViewBalance() {
		// TODO Auto-generated method stub
		
	}

	public void Create(BankAccount bankaccount,int userid) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
		
		double balance=bankaccount.getBalance();
		
		
		
		
		String sql = "INSERT INTO BANK_ACCOUNT (BANK_ACCOUNT_AMOUNT,USER_ID) VALUES(?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1,balance);
		pstmt.setInt(2, userid);
		pstmt.executeUpdate();
	
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void Update(int accountNumber) {
		// TODO Auto-generated method stub
		
	}

	public void Delete(int accountNumber) {
		// TODO Auto-generated method stub
		
	}

	public void Deposit(BankAccount bank,double amount) {
		// TODO Auto-generated method stub
		
	}

	public void Withdraw(BankAccount bank,double amount) {
		// TODO Auto-generated method stub
		
	}

}
