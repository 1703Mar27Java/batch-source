package com.revature.BankAssignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.BankAssignment.domain.User;
import com.revature.BankAssignment.exceptions.IncorrectPassword;
import com.revature.BankAssignment.util.ConnectionUtil;



public class UserDAOImpl implements UserDAO {

	public void CreateUser(User user) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
		
		String username=user.getUsername();
		String password=user.getPassword();
		
		
		
		String sql = "INSERT INTO USERS (USER_NAME,USER_PASSWORD) VALUES(?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		pstmt.executeUpdate();
	
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void DeleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void Logout() {
		// TODO Auto-generated method stub
		
	}

	public void CreateNewAccount(User user) {
		// TODO Auto-generated method stub
		
	}

	public void UpdateAccount(int accountNumber) {
		// TODO Auto-generated method stub
		
	}

	public void DeleteAccount(User user,int accountNumber) {
		// TODO Auto-generated method stub
		
	}

	public void ViewAllAccounts() {
		// TODO Auto-generated method stub
		
	}

	public void Deposit(User user,int accountNumber,double amount) {
		// TODO Auto-generated method stub
		
	}

	public void Withdraw(User user,int accountNumber,double amount) {
		// TODO Auto-generated method stub
		
	}

	public boolean Login(User user) throws IncorrectPassword {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
		
		String username=user.getUsername();
		String password=user.getPassword();
		
		
		
		String sql = "SELECT * FROM USERS WHERE USER_NAME=? AND USER_PASSWORD=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
	
		
	
		ResultSet result=pstmt.executeQuery();
		
		
		
		if(!result.next()){
			throw new IncorrectPassword();
		}
	user.setId(result.getInt(1));
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	
	

}
