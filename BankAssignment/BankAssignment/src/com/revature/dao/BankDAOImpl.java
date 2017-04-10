package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.revature.domain.BankAccount;
import com.revature.domain.BankUser;
import com.revature.util.ConnectionUtil;

public class BankDAOImpl implements BankDAO 
{
	private static final String  filename = "connection.properties";

	@Override
	public void createUser(BankUser user) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) 
		{
			
			//we're autogenerating out PKs in the database
			//because we're not barbarians 
			String userName = user.getUserName();
			String userPassword = user.getUserPassword();
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			
			String sql = "INSERT INTO BANK_USER (USERNAME,USER_PW,FIRSTNAME,LASTNAME) "
					+ "VALUES ('"+userName+"','"+userPassword+"','"+firstName+"','"+lastName+"'"+")";
			
			PreparedStatement statement = con.prepareStatement(sql);
			int numRowsAffected = statement.executeUpdate();
			if (numRowsAffected == 1) 
			{
				System.out.println("user "+firstName+" "+lastName+" created successfully!\n");
			}
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
	}

	@Override
	public BankUser retrieveUserById(int userID) 
	{
		BankUser user = new BankUser();
		try 
		{
			Connection con;
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM BANK_USER WHERE USER_ID = "+ userID;
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			
			while (results.next())
			{
				user.setUserID(Integer.parseInt(results.getString("USER_ID")));
				user.setUserName(results.getString("USERNAME"));
				user.setUserPassword(results.getString("USER_PW"));
				user.setFirstName(results.getString("FIRSTNAME"));
				user.setLastName(results.getString("LASTNAME"));
			}
			return user;
			
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			return user;
		} 
		catch (IOException e) {
			e.printStackTrace();
			return user;
		}
	}

	@Override
	public void deleteUser(int userID) 
	{
		try 
		{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "DELETE BANK_USER WHERE USER_ID =" + userID;
			PreparedStatement pstmt = con.prepareStatement(sql); 
			int numRowsAffected = pstmt.executeUpdate();
			if(numRowsAffected == 1)
			{
				System.out.println("User successfully deleted.\n");

			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(BankUser user) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) 
		{
			String userName = user.getUserName();
			String userPassword = user.getUserPassword();
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			int userID = user.getUserID();
			
			String sql = 
					"UPDATE BANK_USER SET USERNAME = (?), USER_PW = (?), FIRSTNAME = (?), LASTNAME = (?) WHERE USER_ID = (?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, userPassword);
			statement.setString(3, firstName);
			statement.setString(4, lastName);
			statement.setInt(5, userID);			
			
			int numRowsAffected = statement.executeUpdate();
			if (numRowsAffected == 1) 
			{
				System.out.println("user "+firstName+" "+lastName+" updated successfully!\n");
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<BankUser> retrieveAllUsers() 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) 
		{
		
			List<BankUser> userList = new ArrayList<BankUser>();
			BankUser addedUser = new BankUser();
			String sql = "SELECT * FROM BANK_USER";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			System.out.print("User ID: \t");
			System.out.print("First name: \t");
			System.out.print("Last name: \t");
			System.out.print("Username: \t");
			System.out.println("User Password: \t");

			while (results.next())
			{
				addedUser.setUserID(Integer.parseInt(results.getString("USER_ID")));
				System.out.print(addedUser.getUserID()+ "\t\t");
				
				addedUser.setFirstName(results.getString("FIRSTNAME"));
				System.out.print(addedUser.getFirstName()+ "\t\t");
				
				addedUser.setLastName(results.getString("LASTNAME"));
				System.out.print(addedUser.getLastName()+ "\t\t");
				
				addedUser.setUserName(results.getString("USERNAME"));
				System.out.print(addedUser.getUserName()+ "\t\t");
				
				addedUser.setUserPassword(results.getString("USER_PW"));
				System.out.println(addedUser.getUserPassword()+ "\t\t");
				
				userList.add(addedUser);
			}
			System.out.println();
			return userList;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
			return null;
		}
	}

	@Override
	public List<BankAccount> viewAccounts(int userID) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) 
		{
		
			List<BankAccount> accountList = new LinkedList<BankAccount>();
			BankAccount addedAccount = new BankAccount();
			String sql = "SELECT * FROM BANK_ACCOUNT";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			System.out.print("Account Name: \t");
			System.out.print("Balance: \t");
			System.out.println();

			while (results.next())
			{
				addedAccount.setUserID(Integer.parseInt(results.getString("USER_ID")));
					
				addedAccount.setAccountID(Integer.parseInt(results.getString("BANK_ACCOUNT_ID")));
				System.out.println("Acct ID: " + addedAccount.getAccountID());
					
				addedAccount.setAccountName(results.getString("ACCOUNT_NAME"));
				System.out.print(" " + addedAccount.getAccountName()+ "\t\t");
				
				addedAccount.setBalance(Double.parseDouble(results.getString("BALANCE")));
				System.out.print(addedAccount.getBalance()+ "\t\t");
					
				accountList.add(addedAccount);
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
		}
	}


	@Override
	public void withdrawal(int bankID, double amount) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) 
		{
			String sql = "UPDATE BANK_ACCOUNT SET BALANCE = BALANCE -" + amount + " WHERE BANK_ACCOUNT_ID = " + bankID;
			
			PreparedStatement statement = con.prepareStatement(sql);
			int numRowsAffected = statement.executeUpdate();
			if (numRowsAffected == 1) 
			{
				System.out.println("Withdrawal successful!\n");
			}
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		} 		
	}

	@Override
	public void deposit(int bankID, double amount) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) 
		{
			String sql = "UPDATE BANK_ACCOUNT SET BALANCE = BALANCE +" + amount + " WHERE BANK_ACCOUNT_ID = " + bankID;
			
			PreparedStatement statement = con.prepareStatement(sql);
			int numRowsAffected = statement.executeUpdate();
			if (numRowsAffected == 1) 
			{
				System.out.println("Deposit successful!\n");
			}
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
	}

	@Override
	public void deleteAccount(int bankID) 
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
			}
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void createAccount(BankAccount account) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) 
		{
			double balance = account.getBalance();
			int userID = account.getUserID();
			
			String sql = "INSERT INTO BANK_ACCOUNT (BALANCE, USER_ID) "
					+ "VALUES ("+ balance +","+ userID +")";
			
			PreparedStatement statement = con.prepareStatement(sql);
			int numRowsAffected = statement.executeUpdate();
			if (numRowsAffected == 1) 
			{
				System.out.println("Account created successfully!");
			}
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
	}

	@Override
	public BankUser retrieveUserByUserName(String userName) 
	{
		BankUser user = new BankUser();
		try 
		{
			Connection con;
			con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "SELECT * FROM BANK_USER WHERE USERNAME = "+ "'" +userName +"'";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet results = pstmt.executeQuery();
			while (results.next())
			{
				user.setUserID(Integer.parseInt(results.getString("USER_ID")));
				user.setUserName(results.getString("USERNAME"));
				user.setUserPassword(results.getString("USER_PW"));
				user.setFirstName(results.getString("FIRSTNAME"));
				user.setLastName(results.getString("LASTNAME"));
			}
			return user;
			
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			return user;
		} 
		catch (IOException e) {
			e.printStackTrace();
			return user;
		}
		
	}

	@Override
	public BankAccount retrieveAccount(int bankID) 
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
				acct.setAccountID(Integer.parseInt(results.getString("FIRSTNAME")));
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
		}
	}

}
