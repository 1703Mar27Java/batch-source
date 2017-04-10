package com.revature.domain;

public class BankAccount {
	
	private int accountID;
	private int userID;
	private double balance;
	private String accountName;
	
	public int getAccountID() 
	{
		return accountID;
	}
	
	public void setAccountID(int accountID) 
	{
		this.accountID = accountID;
	}
	
	public Double getBalance() 
	{
		return balance;
	}
	
	public void setBalance(Double balance) 
	{
		this.balance = balance;
	}
	
	public int getUserID() 
	{
		return userID;
	}
	
	public void setUserID(int userID) 
	{
		this.userID = userID;
	}
	
	public String getAccountName() 
	{
		return accountName;
	}
	
	public void setAccountName(String accountName) 
	{
		this.accountName = accountName;
	}
		
	@Override
	public String toString() {
		return accountName +"Account\n" + "Balance = "+ balance + "\n";
	}

	public BankAccount()
	{
		
	}
	
	public BankAccount(int accountID, double balance, int userID) {
		this.accountID = accountID;
		this.balance = balance;
		this.userID = userID;
	}

}
