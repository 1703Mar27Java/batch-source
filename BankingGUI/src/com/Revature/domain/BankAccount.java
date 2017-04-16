package com.Revature.domain;

public class BankAccount {
	private int accountID;
	private int userID;
	private String accountName;
	private double balance;
	
	public BankAccount() {
		super();
	}
	public BankAccount(int userID, String accountName, double balance) {
		super();
		this.userID = userID;
		this.accountName = accountName;
		this.balance = balance;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [accountID=" + accountID + ", userID=" + userID + ", accountName=" + accountName
				+ ", balance=" + balance + "]";
	}
	
}
