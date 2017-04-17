package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.revature.domain.BankAccount;
import com.revature.util.ConnectionUtil;

public class BankAccountDAOImpl implements BankAccountDAO
{
	@Override
	public BankAccount retrieveAccount(int bankID, String filename) 
	{
		BankAccount acct = new BankAccount();
		try 
		{
			Connection con;
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = "+ bankID;
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			
			while (results.next())
			{
				acct.setUserID(Integer.parseInt(results.getString("USER_ID")));
				acct.setAccountName(results.getString("ACCOUNT_NAME"));
				acct.setBalance(Double.parseDouble(results.getString("BALANCE")));
				acct.setAccountID(Integer.parseInt(results.getString("BANK_ACCOUNT_ID")));
			}
			return acct;
			
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		} 
		catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<BankAccount> viewAccounts(int userID, String filename) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) 
		{
		
			List<BankAccount> accountList = new ArrayList<BankAccount>();
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE USER_ID =" + userID;
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			System.out.print("Account Name: \t");
			System.out.print("Balance: \t");
			System.out.println();

			while (results.next())
			{
				BankAccount acct = new BankAccount();

				acct.setUserID(Integer.parseInt(results.getString("USER_ID")));
					
				acct.setAccountID(Integer.parseInt(results.getString("BANK_ACCOUNT_ID")));
				System.out.println("Acct ID: " + acct.getAccountID());
					
				acct.setAccountName(results.getString("ACCOUNT_NAME"));
				System.out.print(" " + acct.getAccountName()+ "\t\t");
				
				acct.setBalance(Double.parseDouble(results.getString("BALANCE")));
				System.out.print(acct.getBalance()+ "\t\t");
					
				accountList.add(acct);
				System.out.println();
				System.out.println();
			}
			System.out.println();
			return accountList;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		} 
		
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
			return null;
		}
	}



	@Override
	public boolean withdrawal(int bankID, double amount, String filename) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) 
		{
			String sql = "UPDATE BANK_ACCOUNT SET BALANCE = BALANCE -" + amount + " WHERE BANK_ACCOUNT_ID = " + bankID;
			
			PreparedStatement statement = con.prepareStatement(sql);
			int numRowsAffected = statement.executeUpdate();
			if (numRowsAffected == 1) 
			{
				System.out.println("Withdrawal successful!\n");
				return true;
			}
			
			else
			{
				return false;
			}
				
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
			return false;
		} 		
	}



	@Override
	public boolean deposit(int bankID, double amount, String filename) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) 
		{
			String sql = "UPDATE BANK_ACCOUNT SET BALANCE = BALANCE +" + amount + " WHERE BANK_ACCOUNT_ID = " + bankID;
			
			PreparedStatement statement = con.prepareStatement(sql);
			int numRowsAffected = statement.executeUpdate();
			if (numRowsAffected == 1) 
			{
				System.out.println("Deposit successful!\n");
				return true;
			}
			
			else
			{
				return false;
			}
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		} 
		catch (ClassNotFoundException e1)
		{
			e1.printStackTrace();
			return false;
		} 
	}



	@Override
	public boolean deleteAccount(int bankID, String filename) 
	{
		try 
		{
			Connection con;
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "DELETE FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = "+ bankID;
			PreparedStatement pstmt = con.prepareStatement(sql);
			int numRowsAffected = pstmt.executeUpdate();
			if (numRowsAffected == 1) 
			{
				System.out.println("Account deleted successfully");
				return true;
			}
			
			else
			{
				return false;
			}
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}



	@Override
	public boolean createAccount(BankAccount account, String filename) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) 
		{
			double balance = account.getBalance();
			int userID = account.getUserID();
			String acctName = account.getAccountName();
			
			String sql = "INSERT INTO BANK_ACCOUNT (BALANCE, USER_ID, ACCOUNT_NAME) "
					+ "VALUES ("+ balance +","+ userID +","+ "'" + acctName + "'" +")";
			
			PreparedStatement statement = con.prepareStatement(sql);
			int numRowsAffected = statement.executeUpdate();
			if (numRowsAffected == 1) 
			{
				System.out.println("Account created successfully!");
				return true;
			}
			
			else
			{
				return false;
			}
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
			return false;
		} 
		catch (ClassNotFoundException e2)
		{
			e2.printStackTrace();
			return false;
		}
		
	}


}
