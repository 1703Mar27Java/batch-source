package com.revature.dao;

import java.util.List;

import com.revature.domain.BankAccount;
import com.revature.domain.BankUser;

public interface BankDAO 
{
	public void createUser(BankUser user);
	public BankUser retrieveUserById(int userID);
	public BankUser retrieveUserByUserName(String userName);
	public void deleteUser(int userID);
	public void updateUser(BankUser user);
	public List<BankUser> retrieveAllUsers();
	public BankAccount retrieveAccount(int bankID);
	public List<BankAccount> viewAccounts(int userID);
	public void withdrawal(int bankID, double amount);
	public void deposit(int bankID, double amount);
	public void deleteAccount(int bankID);
	public void createAccount(BankAccount account);
}

