package com.revature.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import com.revature.dao.BankUserDAOImpl;
import com.revature.domain.BankUser;



public class BankUserUtil 
{
	private static final String filename = new File("C:\\Revature\\BankAssignmentWithUI\\connection.properties").getAbsolutePath();

	public static boolean createUserHelper(String username, String password, String firstName, String lastName)
	{
		BankUser user = new BankUser();
		user.setUserName(username);
		user.setUserPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		if(username == null || password == null)
		{
			return false;
		}
		else
		{
			BankUserDAOImpl dao = new BankUserDAOImpl();
			return dao.createUser(user, filename);
		}
	}
	
	public static boolean userCredCheck(String username, String password)
	{
		BankUserDAOImpl dao = new BankUserDAOImpl();
		BankUser checkAgainst = dao.retrieveUserByUserName(username,filename);
		
		BankUser user = new BankUser();
		user.setUserName(username);
		user.setUserPassword(password);
		
		if(user.getUserPassword().equals(checkAgainst.getUserPassword()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isSuperUser(String username, String password)
	{
		Properties prop = new Properties();
		try 
		{
			InputStream in = new FileInputStream(filename);
			prop.load(in);
			if(username.equals(prop.getProperty("mUsername")) && password.equals(prop.getProperty("mPassword")))
			{
				return true;
			}
		} 
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return false;
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
	
	public static boolean deleteUserHelper (String username)
	{
		BankUserDAOImpl dao = new BankUserDAOImpl();
		return dao.deleteUser(username, filename);
	}

	public static BankUser getBankUserHelper(String username)
	{
		BankUserDAOImpl dao = new BankUserDAOImpl();
		return dao.retrieveUserByUserName(username, filename);
	}
	
	public static List<BankUser> getAllBankUsersHelper()
	{
		ArrayList<BankUser> userList = new ArrayList<BankUser>();
		BankUserDAOImpl dao = new BankUserDAOImpl();
		userList = (ArrayList<BankUser>)dao.retrieveAllUsers(filename);
		return userList;
	}

	public static boolean updateBankUserHelper(int userID, String username, String password, String firstName,
			String lastName)
	{
		BankUserDAOImpl dao = new BankUserDAOImpl();
		BankUser user = dao.retrieveUserById(userID, filename);
		
		


		if(username.equals("") || username == null)
		{
			return false;
		}
		else
		{
			user.setUserName(username);
		}
		
		if(!password.equals("") || password != null)
		{
			user.setUserPassword(password);
		}
		if(!firstName.equals("") || firstName != null)
		{
			user.setFirstName(firstName);
		}
		if(!lastName.equals("") || lastName != null)
		{
			user.setLastName(lastName);
		}

		return dao.updateUser(user, filename);

	}

}
