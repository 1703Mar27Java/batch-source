package com.revature.Domain;

public class Bank {
	
	public int bankID;
	public int userID;
	public float balance;
	public String bankName;
	
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bank(int bankID, int userID, float balance, String bankName) {
		this();
		this.bankID = bankID;
		this.userID = userID;
		this.balance = balance;
		this.bankName = bankName;
	}
	
	public Bank(int userID, float balance, String bankName) {
		this();
		this.userID = userID;
		this.balance = balance;
		this.bankName = bankName;
	}

	public int getBankID() {
		return bankID;
	}
	public void setBankID(int bankID) {
		this.bankID = bankID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Override
	public String toString() {
		return "Bank [bankID=" + bankID + ", userID=" + userID + ", balance=" + balance + ", bankName=" + bankName
				+ "]";
	}
	
}
