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

//import oracle.jdbc.OracleTypes;



public class UserDAOImpl implements UserDAO {

	public boolean CreateUser(User user) {
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
			return false;
		}
		
		return true;
		
	}

	public boolean DeleteUser(int id) {

		
		String sql="DELETE FROM BANK_ACCOUNT WHERE  USER_ID=?";
		String sql2="DELETE FROM USERS WHERE USER_ID=?";
		try {
			Connection con=ConnectionUtil.getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt=con.prepareStatement(sql2);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			System.out.println("User number"+id+"has been deleted");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
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

	public boolean DeleteAccount(User user,int accountNumber) {
		Connection con;
		String check="SELECT BANK_ACCOUNT_AMOUNT FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_NUMBER=?";
	String sql="DELETE FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_NUMBER=? AND USER_ID=?";
		try {
			con=ConnectionUtil.getConnection();
			
			PreparedStatement pstmt=con.prepareStatement(check);
			pstmt.setInt(1, accountNumber);
			ResultSet result=pstmt.executeQuery();
			result.next();
			if(!(result.getDouble(1)>0)){
			
		pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, accountNumber);
			pstmt.setInt(2, user.getId());
			
		int numrowsaffected=pstmt.executeUpdate();
		
		if(numrowsaffected>0){
			System.out.println("Your account "+accountNumber+" was successfully deleted");
			return true;
		}
		else{
			System.out.println("Your account "+accountNumber+" Could not be deleted you may have entered the wrong number");
			return false;
		}
			}
			else{
				System.out.println("Your account "+accountNumber+" can not be deleted until it is empty of funds");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	public String ViewAllAccounts(User user) {
		Connection con;
		
		String sql="SELECT * FROM BANK_ACCOUNT WHERE USER_ID=?";
	
		String output="";
		try {
			con = ConnectionUtil.getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			
			
ResultSet result=pstmt.executeQuery();
			output+="<table border=\"1\" width=\"100%\"><th>Account number</th><th>Balance</th>";
while(result.next()){
	System.out.println("Account number"+" "+"Balance");
	
	System.out.println(result.getInt(2)+" "+result.getDouble(3));
	output+="<tr><td>"+result.getInt(2)+"</td><td>"+result.getDouble(3)+"</td></tr>";
}
output+="</table>";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
		
		
	}

	public boolean Deposit(User user,int accountNumber,double amount) {
		
		try {
			Connection con=ConnectionUtil.getConnection();
			String sql="{call DEPOSIT(?,?)}";
			String check="SELECT * FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_NUMBER=? AND USER_ID=?";
			CallableStatement cstmt=con.prepareCall(sql);
			cstmt.setInt(1,accountNumber);
			cstmt.setDouble(2, amount);
			PreparedStatement pstmt=con.prepareStatement(check);
			pstmt.setInt(1, accountNumber);
			pstmt.setInt(2, user.getId());
			ResultSet result=pstmt.executeQuery();
			
			if(result.next()){
			if(!cstmt.execute()){
				System.out.println("Your deposit of "+amount+"dollars was successful");
				return true;
			}
			else{System.out.println("Error: your deposit failed for an unknown reason");return false;}
			}
			else{
				System.out.println("You entered the wrong account number please try again");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	public boolean Withdraw(User user,int accountNumber,double amount) {
		try {
			Connection con=ConnectionUtil.getConnection();
			String sql="{call WITHDRAW(?,?)}";
			String check="SELECT * FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_NUMBER=? AND USER_ID=?";
			CallableStatement cstmt=con.prepareCall(sql);
			cstmt.setInt(1,accountNumber);
			cstmt.setDouble(2, amount);
			PreparedStatement pstmt=con.prepareStatement(check);
			pstmt.setInt(1, accountNumber);
			pstmt.setInt(2, user.getId());
			ResultSet result=pstmt.executeQuery();
			
			if(result.next()){
				
				if(result.getInt(3)<amount){
					System.out.println("Your withdrawl failed because you don't have enough money");
					return false;
				}
				
				
			if(!cstmt.execute()){
				System.out.println("Your withdrawl of "+amount+"dollars was successful");
				return true;
			}
			else{System.out.println("Error: your withdrawl failed for an unknown reason");return false;}
			}
			else{
				System.out.println("You entered the wrong account number please try again");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean Login(User user) throws IncorrectPassword {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
		System.out.println("connection successful");
		String username=user.getUsername();
		String password=user.getPassword();
		System.out.println("Username: "+username+" Password: "+password);
		
		
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

	@Override
	public boolean Update(int id, String username, String password) {
		String sql="UPDATE USERS SET USER_NAME=?,USER_PASSWORD=? WHERE USER_ID=?";
		
		try {
			Connection con=ConnectionUtil.getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(3, id);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.executeUpdate();
			
			
			System.out.println("User number"+id+"has been updated");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	
	

}
