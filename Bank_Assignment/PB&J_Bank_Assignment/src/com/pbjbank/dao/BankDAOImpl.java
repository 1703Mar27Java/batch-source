package com.pbjbank.dao;



import java.io.IOException;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pbjbank.domain.*;
import com.pbjbank.util.*;


	public class BankDAOImpl implements BankDAO {
		
		
		@Override
			public void createBankAccount(BankAccount bankAccount) {		
				
			try{
				Connection con = ConnectionUtil.getConnection(); 
				int a = bankAccount.getBankID();
				int u = bankAccount.getUserID();
				String n = bankAccount.getBaName();
				double b = bankAccount.getBal();
				
				String sql = "INSERT INTO BANK_ACCOUNT (BANK_ACCOUNT_ID,USER_ID,BANK_ACCOUNT_NAME,BALANCE) VALUES ('"+a+"','"+u+"','"+n+"','"+b+"')";
				
				Statement statement = con.createStatement();
				int numRowsAffected = statement.executeUpdate(sql);
				System.out.println(numRowsAffected);
				
			} catch (SQLException e){
				e.printStackTrace();
			}
		}

	
		
		@Override
		public void createBankAccountPS(BankAccount bankAccount)  {
			try{
				Connection con = ConnectionUtil.getConnectionFromFile();
				int a = bankAccount.getBankID();
				int u = bankAccount.getUserID();
				String n = bankAccount.getBaName();
				double b = bankAccount.getBal();
				
				String sql = "INSERT INTO BANK_ACCOUNT (BANK_ACCOUNT_ID,USER_ID,BANK_ACCOUNT_NAME,BALANCE) VALUES (?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(0, a);
				pstmt.setInt(0, u);
				pstmt.setString(1, n);
				pstmt.setDouble(2, b);
				int numRowsAffected = pstmt.executeUpdate();
				System.out.println(numRowsAffected);
			}catch(SQLException | IOException e){
				e.printStackTrace();
			}
			
			
		}

		

		@Override
		public void updateBank(BankAccount bankAccount) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteBank(int bankID) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<BankAccount> retrieveAllBankAccounts() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BankAccount retrieveBankById(int bankID) {
			// TODO Auto-generated method stub
			return null;
		}

// User Login

		@Override
		public void createNewUser(User_Logon userLogon) {
		
		try{	 
			Connection con = ConnectionUtil.getConnection(); 
			int u = userLogon.getuserID();
			String n = userLogon.getUserName();
			String p = userLogon.getPassword();
			
			
			String sql = "INSERT INTO USER_LOGON (USER_ID, USER_NAME,PASSWORD) VALUES ('"+u+"','"+n+"','"+p+"')";
			
			Statement statement = con.createStatement();
			int numRowsAffected = statement.executeUpdate(sql);
			System.out.println(numRowsAffected);
			
		} catch (SQLException e){
			e.printStackTrace();
		}
			
		
		}


		@Override
		public void createNewUserPS(User_Logon userLogon) {
			// TODO Auto-generated method stub
			
				try{
					Connection con = ConnectionUtil.getConnectionFromFile();
					int u = userLogon.getuserID();
					String n = userLogon.getUserName();
					String p = userLogon.getPassword();
					
					String sql = "INSERT INTO USER_LOGON (USER_ID, USER_NAME,PASSWORD) VALUES (?,?,?)";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, u);
					pstmt.setString(1, n);
					pstmt.setString(1, p);
					int numRowsAffected = pstmt.executeUpdate();
					System.out.println(numRowsAffected);
				}catch(SQLException | IOException e){
					e.printStackTrace();
				}
				
				
			}	



		@Override
		public User_Logon retrieveUserName(String userName) {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public List<User_Logon> retrieveAllUser_Logons() {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public void updateLogon(User_Logon userLogon) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void deleteLogon(String userName) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void userInput() {
			 Scanner input = new Scanner(System.in);
			 
				try{
					int opt = input.nextInt();
					//	int opt2 = input.nextInt();
						String un = input.nextLine();
						String pw = input.nextLine();
						
						
						System.out.print("Welcome to PB&J Bank!\nPress 1 to log on or Press 2 to create a new account: ");
						
							input.nextInt();
							System.out.print("Please enter your username: ");
							un = input.nextLine();
							System.out.print("Please enter your password: ");
							pw = input.nextLine();
							
					/*	if (input.nextInt() == 1){
							System.out.print("Please enter your username: ");
							un = input.nextLine();
							System.out.print("Please enter your password: ");
							pw = input.nextLine();
							
						}*/
					
				}finally{
					
					
		}
		
	}
				
				
				
				



	}


			
		

