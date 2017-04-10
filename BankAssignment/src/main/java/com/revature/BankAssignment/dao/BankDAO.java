package com.revature.BankAssignment.dao;

import com.revature.BankAssignment.domain.BankAccount;
import com.revature.BankAssignment.domain.User;

public interface BankDAO {
public void ViewBalance();
public void Create(BankAccount bankaccount,int userid);
public void Update(int accountNumber);
public void Delete(int accountNumber);
public void Deposit(BankAccount bank,double amount);
public void Withdraw(BankAccount bank,double amount);
}
