package com.revature.bankdao;

import com.revature.domain.Bank;

public interface BankDao {

	public void logIn(String username, String password);
	public void Deposit(int money);
	public void Withdraw(int money);
	public void Balance(int money);
	public void DeleteAccount(int id);
	public void createUser(Bank user);
}
