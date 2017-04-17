package com.pbjbank.dao;

import java.util.List;

import com.pbjbank.domain.User_Logon;

public interface BankUserDAO {

//	public void createNewUser(User_Logon userLogon);
	public void createNewUserPS(User_Logon userLogon);
	public void  retrieveUserName(String userName, String password);
	public List<User_Logon> retrieveAllUser_Logons();
	public void updateUser(User_Logon userLogon);
	public void deleteUser(String userName);
	
	
	
}
