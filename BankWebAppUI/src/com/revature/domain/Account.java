package com.revature.domain;

public class Account {
	public Account(String account_name, double balance,int id ) {
		super();
		this.id = id;
		this.balance = balance;
		this.account_name = account_name;
	}
	public Account(String account_name, double balance) {
		super();
		this.balance = balance;
		this.account_name = account_name;
	}
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int accountid;
	private int id;
	private double balance;
	private String account_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
}
