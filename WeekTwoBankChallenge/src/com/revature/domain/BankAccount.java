package com.revature.domain;

/*
 * Bank_accountID(PK)
 * UserID(FK)
 * Bank_account_name
 * Balance
 */

//this is where the db vars are set

public class BankAccount {
	///private int bank_accountID;
	private String bank_account_name;
	private int userID;
	private double balance;
	private int bank_accountID;
	
	public BankAccount(){
		super();
	}
	public BankAccount(String bank_account_name, double balance, int userID){
		this();
		this.bank_account_name = bank_account_name;
		this.userID = userID;
		this.balance = balance;
	}
	public void setBank_accountID(int bank_accountID) {
		this.bank_accountID = bank_accountID;
	}
	public String getBank_account_name() {
		return bank_account_name;
	}
	public int getBank_account_id(){
		return bank_accountID;
	}
	public void setBank_account_name(String bank_account_name) {
		this.bank_account_name = bank_account_name;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [bank_account_name=" + bank_account_name + ", userID=" + userID + ", balance=" + balance
				+ ", bank_accountID=" + bank_accountID + "]";
	}
	
	
	
}
