package com.revature.dao;

import java.util.List;

import com.revature.domain.Account;

public interface AccountDAO {
	public void createAccount(int id, String name);
	public int retrieveAccountId(int userId, String accName);
	public List<Account> retrieveAllAccounts(int id);
	public void updateAccount(int id, String updatedStr);
	public void updateBalance(int id, int updatedBal);
	public void deleteAccount(int id);
}
