package com.revature.BankAssignment.dao;

import com.revature.BankAssignment.domain.BankAccount;

public interface BankDAO {
public void ViewBalance();
public BankAccount Create();
public void Update(int accountNumber);
public void Delete(int accountNumber);
public void Deposit(BankAccount bank,double amount);
public void Withdraw(BankAccount bank,double amount);
}
