package com.revature.domain;

public class Bank {
	public Bank(int id, double balance, String username, String password) {
		super();
		this.id = id;
		this.balance = balance;
		this.username = username;
		this.password = password;
	}
	public Bank() {
		super();
		
	}
public Bank(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
private int id;
private double balance;
private String username;
private String password;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Bank [username=" + username + ", password=" + password + "]";
}
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
}
