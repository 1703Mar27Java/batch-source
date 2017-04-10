package com.revature.BankAssignment.dao;

import com.revature.BankAssignment.domain.User;
import com.revature.BankAssignment.exceptions.IncorrectPassword;

public interface UserDAO {
public void CreateUser(User user);
public void DeleteUser(User user);
public boolean Login(User user) throws IncorrectPassword;
public void Logout();
public void CreateNewAccount(User user);
public void UpdateAccount(int accountNumber);
public void DeleteAccount(User user,int accountNumber);
public void ViewAllAccounts(User user);
public void Deposit(User user,int accountNumber,double amount);
public void Withdraw(User user,int accountNumber,double amount);
}
