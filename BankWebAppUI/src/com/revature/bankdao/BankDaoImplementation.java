package com.revature.bankdao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public Bank logIn(String username, String password) {
		Bank user = null;
		try  {
			Connection con = ConnectionBankUtil.getConnection();
			String sql = "SELECT USER_ID FROM BANKUSER WHERE USER_NAME = ? AND BANK_PASSWORD = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet result = pstmt.executeQuery();

			user = new Bank(username, password);
			
			result.next();
			result.getInt(1);
			user.setId(result.getInt(1));
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}



}
