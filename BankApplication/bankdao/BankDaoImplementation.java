package com.revature.bankdao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.butil.ConnectionBankUtil;
import com.revature.domain.Bank;

public class BankDaoImplementation implements BankDao {

	@Override
	public void createUser(Bank user) {
		try{
			Connection con = ConnectionBankUtil.getConnection();
			String u = user.getUsername();
			String z = user.getPassword();
			String sql = "INSERT INTO BANKUSER (USER_NAME,BANK_PASSWORD) VALUES (?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u);
			pstmt.setString(2, z);
			int numRowsAffected = pstmt.executeUpdate();
			System.out.println("You have succesfully created a User");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void logIn(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Deposit(int money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Withdraw(int money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Balance(int money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteAccount(int id) {
		// TODO Auto-generated method stub
		
	}

}
