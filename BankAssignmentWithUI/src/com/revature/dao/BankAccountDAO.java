package com.revature.dao;

import java.util.List;
import com.revature.domain.BankAccount;

public interface BankAccountDAO 
{
	public BankAccount retrieveAccount(int bankID, String filename);
	public List<BankAccount> viewAccounts(int userID, String filename);
	public boolean withdrawal(int bankID, double amount, String filename);
	public boolean deposit(int bankID, double amount, String filename);
	public boolean deleteAccount(int bankID, String filename);
	public boolean createAccount(BankAccount account, String filename);
}
