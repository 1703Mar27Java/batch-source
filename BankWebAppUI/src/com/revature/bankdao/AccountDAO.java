package com.revature.bankdao;

import com.revature.domain.Account;
import com.revature.domain.Bank;

public interface AccountDAO {
	public void createAccount(Account acct);
	public void Deposit(int id, double money);
	public void Withdraw(int id, double money);
	public void Balance(double money);
	public void DeleteAccount(int id);
	Account retrieveAccountID(int id);
	
}
