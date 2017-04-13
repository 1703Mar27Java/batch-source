package com.revature.bankdao;

import com.revature.domain.Account;

public interface AccountDAO {
	public void createAccount(Account acct);
	public void Deposit(int id, int money);
	public void Withdraw(int id, int money);
	public void Balance(int money);
	public void DeleteAccount(int id);
	
}
