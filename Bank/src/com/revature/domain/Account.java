package com.revature.domain;

public class Account {
	private String name;
	private int balance;
	private int id;

	public Account() {
		super();
	}

	public Account(String name, int balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public Account(String name, int balance, int id) {
		super();
		this.name = name;
		this.balance = balance;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", balance=" + balance + ", id=" + id + "]";
	}

}
