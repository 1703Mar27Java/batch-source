package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.BankUser;
import com.revature.util.ConnectionUtil;

public class BankUserDAOImpl implements BankUserDAO
{

	@Override
	public boolean createUser(BankUser user, String filename) 
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
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
			return false;
		}
	}

	@Override
	public BankUser retrieveUserById(int userID, String filename) 
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
			return null;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteUser(String username, String filename) 
	{
		try 
		{
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
			String sql = "DELETE BANK_USER WHERE USERNAME =" + "'" + username + "'";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			int numRowsAffected = pstmt.executeUpdate();
			if(numRowsAffected == 1)
			{
				System.out.println("User successfully deleted.\n");
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
	public boolean updateUser(BankUser user, String filename) 
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
		} catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
			return false;
		}
	}

	@Override
	public List<BankUser> retrieveAllUsers(String filename) 
	{
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)) 
		{
		
			List<BankUser> userList = new ArrayList<BankUser>();
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
				BankUser user = new BankUser();
				
				user.setUserID(Integer.parseInt(results.getString("USER_ID")));
				System.out.print(user.getUserID()+ "\t\t");
				
				user.setFirstName(results.getString("FIRSTNAME"));
				System.out.print(user.getFirstName()+ "\t\t");
				
				user.setLastName(results.getString("LASTNAME"));
				System.out.print(user.getLastName()+ "\t\t");
				
				user.setUserName(results.getString("USERNAME"));
				System.out.print(user.getUserName()+ "\t\t");
				
				user.setUserPassword(results.getString("USER_PW"));
				System.out.println(user.getUserPassword()+ "\t\t");
				
				userList.add(user);
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
		
		catch (ClassNotFoundException e2) 
		{
			e2.printStackTrace();
			return null;
		}
	}

	@Override
	public BankUser retrieveUserByUserName(String userName, String filename) 
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
}
