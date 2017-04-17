package com.revature.domain;


public class AwesomeBank {
	
	public AwesomeBank(int accID, String accountName, String password, float accBalance) {
		super();
		this.accID = accID;
		this.accountName = accountName;
		this.password = password;
		this.accBalance = accBalance;
	}
	
	public AwesomeBank(int accID, String accountName, String password) {
		super();
		this.accID = accID;
		this.accountName = accountName;
		this.password = password;
	}
	
	public AwesomeBank(int accID, String accountName, int balance) {
		super();
		this.accID = accID;
		this.accountName = accountName;
		this.accBalance = balance;
	}
	
	
	public AwesomeBank(String accountName, String password) {
		super();
		this.accountName = accountName;
		this.password = password;
	}
	
	public AwesomeBank(int accNum) {
		super();
		this.accID = accNum;
	}
	
	private int accID;
	private String accountName;
	private String  password;
	private float accBalance;
	
	
	public int getAccID() {
		return accID;
	}
	public void setAccID(int accID) {
		this.accID = accID;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getAccBalance() {
		return accBalance;
	}
	public void setAccBalance(float accBalance) {
		this.accBalance = accBalance;
	}
	@Override
	public String toString() {
		return "AwesomeBank [accID=" + accID + ", accountName=" + accountName + ", password=" + password
				+ ", accBalance=" + accBalance + "]";
	}

}
