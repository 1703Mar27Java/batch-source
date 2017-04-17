package com.pbjbank.dao;



import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.pbjbank.domain.*;
import com.pbjbank.util.*;


	public class BankDAOImpl implements BankDAO {
		
		
/*	@Override
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
		}*/

	
		
		@Override
		public void createBankAccountPS(BankAccount bankAccount)   {
			try{
				Connection con = ConnectionUtil.getConnectionFromFile();
				int a = bankAccount.getBankID();
				int u = bankAccount.getUserID();
				String n = bankAccount.getBaName();
				int b = bankAccount.getBal();	
				String sql = "INSERT INTO BANK_ACCOUNT VALUES (?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, a);
				pstmt.setInt(2, u);
				pstmt.setString(3, n);
				pstmt.setDouble(4, b);
				int numRowsAffected = pstmt.executeUpdate();
				System.out.println(numRowsAffected);
			}catch(SQLException | IOException e){
				e.printStackTrace();
			}
			
			
		}

		

		@Override
		public void updateBank(BankAccount bankAccount) {
			try{
				Connection con = ConnectionUtil.getConnectionFromFile();		
				String sql = "UPDATE BANK_ACCOUNT SET BALANCE =:new.BALANCE WHERE BALANCE=:old.BALANCE";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					int bal = rs.getInt("BALANCE");
					System.out.print(bal);		
				}
			}catch(SQLException e){
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
			
		}

		@Override
		public void deleteBank(int bankID) {
			try{
				Connection con = ConnectionUtil.getConnectionFromFile();		
				String sql = "DELETE FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_NAME = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					String name = rs.getString("BANK_ACCOUNT_NAME");
					System.out.print(name);		
				}
			}catch(SQLException e){
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
			
			
		}

		@Override
		public List<BankAccount> retrieveAllBankAccounts() {
			PreparedStatement pstmt = null;
			List<BankAccount> account = new ArrayList<>();
			try{
				Connection con = ConnectionUtil.getConnectionFromFile();
				String sql = "SELECT * FROM BANK_ACCOUNT";
				pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					int id = rs.getInt("BANK_ACCOUNT_ID");
					int uid = rs.getInt("USER_ID");
					String bn = rs.getString("BANK_ACCOUNT_NAME");
					int bal = rs.getInt("BALANCE");
					BankAccount b = new BankAccount(id,uid,bn,bal);
					account.add(b);
				}
			}catch(SQLException e){
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if (pstmt!=null){try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}}
			}return account;
		}

		@Override
		public BankAccount retrieveBankById(int bankID) {
		try{	
			Connection con = ConnectionUtil.getConnectionFromFile();		
		
			String sql = "SELECT BANK_ACCOUNT_ID FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				double id = rs.getDouble("BANK_ACCOUNT_ID");
				System.out.print(id);		
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		return null;
			




		}



			
		
		
	}
				
				
				
				



	


			
		

