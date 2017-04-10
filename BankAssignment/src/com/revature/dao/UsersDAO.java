package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface UsersDAO {
	public void createUser(String USER_NAME, String PASSWORD);
	public int retrieveUserId(String USER_NAME, String PASSWORD);
	public List<Users> retrieveAllUsers();
	public List<Account> retrieveAllAccounts(int uid);
	public void updateUser(int id, int choice, String updatedStr);
	public void deleteUser(int id);
}
