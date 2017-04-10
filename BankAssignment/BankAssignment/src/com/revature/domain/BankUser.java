package com.revature.domain;

public class BankUser 
{
	private int userID;
	private String userName;
	private String userPassword;
	private String firstName;
	private String lastName;
	
	
	public int getUserID() 
	{
		return userID;
	}
	public void setUserID(int userID) 
	{
		this.userID = userID;
	}
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getUserPassword() 
	{
		return userPassword;
	}
	public void setUserPassword(String userPassword) 
	{
		this.userPassword = userPassword;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "UserID: " + userID + "\n" + firstName + " " + lastName  + "\n" + "Username: " +  userName + "\n"+ "Password: "+ userPassword  ;
	}
	
	
	public BankUser()
	{
	}
	
	public BankUser(int userID, String userName, String userPassword)
	{
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
	}

}
