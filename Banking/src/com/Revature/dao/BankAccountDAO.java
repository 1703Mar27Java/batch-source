package com.Revature.dao;

import java.util.List;

import com.Revature.domain.BankAccount;

public interface BankAccountDAO {
	public void createAccount(BankAccount acct);
	public BankAccount retrieveAccountByID(int id);
	public void updateAccount(BankAccount acct, String newName);
	public void deleteBankAccount(int id) throws DeletingNonZeroAccountException;
	public void deposit(BankAccount acct, double amt);
	public void withdraw(BankAccount acct, double amt) throws OverdraftException;
}
