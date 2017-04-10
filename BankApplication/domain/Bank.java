package com.revature.domain;

public class Bank {
	public Bank() {
		super();
		
	}
public Bank(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
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
}
