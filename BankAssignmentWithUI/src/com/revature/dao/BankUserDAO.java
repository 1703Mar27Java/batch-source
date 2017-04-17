package com.revature.dao;

import java.util.List;
import com.revature.domain.BankUser;

public interface BankUserDAO 
{
	public boolean createUser(BankUser user, String filename);
	public BankUser retrieveUserById(int userID, String filename);
	public BankUser retrieveUserByUserName(String username, String filename);
	public boolean deleteUser(String username, String filename);
	public boolean updateUser(BankUser user, String filename);
	public List<BankUser> retrieveAllUsers(String filename);

}
