package com.revature.dao;

import java.util.ArrayList;

import com.revature.domain.Account;
import com.revature.domain.Transaction;
import com.revature.domain.User;

public interface BankDAO {

	public void createUser(String username, String password);
	public User getUser(String username, String password);
	public boolean userExists(String username);
	public void getAccounts(User user);
	public void createAccount(User user, Account account);
	public void deleteAccount(User user, Account account);
	public void depositAccount(Account account, int deposit);
	public void withdrawAccount(Account account, int withdraw);
	public ArrayList<Transaction> getTransaction(Account account);
	public ArrayList<User> getUsers();
	public void deleteUser(String username);
	public void updateUser(String username, String newUsername, String newPassword);
	
}
