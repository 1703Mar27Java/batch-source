package com.revature.BankAssignment.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.revature.BankAssignment.domain.BankAccount;
import com.revature.BankAssignment.domain.User;
import com.revature.BankAssignment.exceptions.IncorrectPassword;
import com.revature.BankAssignment.util.ConnectionUtil;

import oracle.jdbc.OracleTypes;



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
		BankAccount newaccount=new BankAccount(0.00);
		BankDAOImpl newDAO=new BankDAOImpl();
		newDAO.Create(newaccount,user.getId());
		System.out.println("Congratulations you have opened a new bank account");
	}

	public void UpdateAccount(int accountNumber) {
		// TODO Auto-generated method stub
		
	}

	public void DeleteAccount(User user,int accountNumber) {
		Connection con;
		String check="SELECT BANK_ACCOUNT_AMOUNT FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_NUMBER=?";
	String sql="DELETE FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_NUMBER=? AND USER_ID=?";
		try {
			con=ConnectionUtil.getConnection();
			
			PreparedStatement pstmt=con.prepareStatement(check);
			pstmt.setInt(1, accountNumber);
			ResultSet result=pstmt.executeQuery();
			
			if(result.getDouble(1)>0){
			
		pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, accountNumber);
			pstmt.setInt(2, user.getId());
			
		int numrowsaffected=pstmt.executeUpdate();
		
		if(numrowsaffected>0){
			System.out.println("Your account "+accountNumber+" was successfully deleted");
		}
		else{
			System.out.println("Your account "+accountNumber+" Could not be deleted you may have entered the wrong number");
		}
			}
			else{
				System.out.println("Your account "+accountNumber+" can not be deleted until it is empty of funds");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void ViewAllAccounts(User user) {
		Connection con;
		
		String sql="SELECT * FROM BANK_ACCOUNT WHERE USER_ID=?";
	
		
		try {
			con = ConnectionUtil.getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			
			
ResultSet result=pstmt.executeQuery();
			
while(result.next()){
	System.out.println("Account number"+" "+"Balance");
	System.out.println(result.getInt(2)+" "+result.getDouble(3));
}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	public void Deposit(User user,int accountNumber,double amount) {
		
		try {
			Connection con=ConnectionUtil.getConnection();
			String sql="{call DEPOSIT(?,?)}";
			String check="SELECT FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_NUMBER=? AND USER_ID=?";
			CallableStatement cstmt=con.prepareCall(sql);
			cstmt.setInt(1,accountNumber);
			cstmt.setDouble(2, amount);
			PreparedStatement pstmt=con.prepareStatement(check);
			
			ResultSet result=pstmt.executeQuery();
			
			if(result.next()){
			if(cstmt.execute()){
				System.out.println("Your deposit of "+amount+"dollars was successful");
			}
			else{System.out.println("Error: your deposit failed for an unknown reason");}
			}
			else{
				System.out.println("You entered the wrong account number please try again");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void Withdraw(User user,int accountNumber,double amount) {
		try {
			Connection con=ConnectionUtil.getConnection();
			String sql="{call WITHDRAW(?,?)}";
			String check="SELECT FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_NUMBER=? AND USER_ID=?";
			CallableStatement cstmt=con.prepareCall(sql);
			cstmt.setInt(1,accountNumber);
			cstmt.setDouble(2, amount);
			PreparedStatement pstmt=con.prepareStatement(check);
			
			ResultSet result=pstmt.executeQuery();
			
			if(result.next()){
			if(cstmt.execute()){
				System.out.println("Your withdrawl of "+amount+"dollars was successful");
			}
			else{System.out.println("Error: your withdrawl failed for an unknown reason");}
			}
			else{
				System.out.println("You entered the wrong account number please try again");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
