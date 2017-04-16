package com.Revature.dao;

import java.util.List;

import com.Revature.domain.BankAccount;
import com.Revature.domain.User;

public interface UserDAO {
	public void createUser(User user);
	public User UserByID(int id);
	public User UserByLogin(String username, String password) throws IncorrectLoginException;
	public List<User> retrieveAllUsers();
	public List<BankAccount> retrieveAccounts(int userid);
	public void updateUserName(User user, String username);
	public void updateUserPass(User user, String pass);
	public void deleteUser(int id);
}
