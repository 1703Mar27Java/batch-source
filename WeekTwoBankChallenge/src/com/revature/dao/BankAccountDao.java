package com.revature.dao;

import java.util.List;

import com.revature.domain.BankAccount;
import com.revature.domain.User;

//I assume that each DAOIMPL object represents a handle for managment of the same database
//(if you instantiate classes twice, two seperate handlers will be created
//that manage the same database.

public interface BankAccountDao {
	public void createAccount(BankAccount account);
	public BankAccount retrieveAccountById(int id);
	public List<BankAccount> retrieveAllAccount();
	public void updateAccount(BankAccount account, String action, double depAmt);
	public void deleteAccount(int id);
	public void switchAccount(int acctId, int usrId);
	public void createAccountPS(BankAccount account);
	public BankAccount retrieveAccountByAcctId(int accountId);
}
