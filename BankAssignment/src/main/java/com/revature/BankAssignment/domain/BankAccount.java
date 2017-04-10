package com.revature.BankAssignment.domain;

public class BankAccount {
private int id;
private int accountNumber;
private double balance;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
@Override
public String toString() {
	return "BankAccount [id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance + "]";
}
public BankAccount(int id, int accountNumber, double balance) {
	super();
	this.id = id;
	this.accountNumber = accountNumber;
	this.balance = balance;
}
}
