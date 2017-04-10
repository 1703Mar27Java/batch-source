package com.revature.domain;

import java.util.ArrayList;

public class User {
	private String username;
	private String password;
	private int id;
	private ArrayList<Account> accounts;

	public User() {
		super();
	}

	public User(String username, String password, int uId) {
		super();
		this.username = username;
		this.password = password;
		this.id = uId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getuId() {
		return id;
	}

	public void setuId(int uId) {
		this.id = uId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passWord) {
		this.password = passWord;
	}

	public ArrayList<Account> getAccounts() {
		return this.accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public Account getAccount(String accountName) {
		for (Account a : accounts) {
			if (a.getName().equals(accountName)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "id= " + id + ", username= " + username + ", password= " + password;
	}

}
