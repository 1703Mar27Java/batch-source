package com.revature.BankAssignment.dao;

import com.revature.BankAssignment.domain.User;
import com.revature.BankAssignment.exceptions.IncorrectPassword;

public interface UserDAO {
public boolean CreateUser(User user);
public boolean DeleteUser(int id);
public boolean Login(User user) throws IncorrectPassword;
public void Logout();
public void CreateNewAccount(User user);
public boolean Update(int id,String username,String password);
public void UpdateAccount(int accountNumber);
public boolean DeleteAccount(User user,int accountNumber);
public String ViewAllAccounts(User user);
public boolean Deposit(User user,int accountNumber,double amount);
public boolean Withdraw(User user,int accountNumber,double amount);
}
