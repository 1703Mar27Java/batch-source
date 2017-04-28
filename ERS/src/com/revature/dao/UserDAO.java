package com.revature.dao;

import com.revature.bean.User;

public interface UserDAO {
	public String logIn(String name, String pass);
	public User getUser(String userName);
	public void resetPass(String userName, String email);
	public boolean updateUser(String user, String email, String fName, String lName);
	public boolean updatePw(String user, String pw);
	public boolean isMgr(String user);
	public boolean mgrUpdateUser(String user, String email, String fName, String lName, String title);
	public boolean makeUser(String e, String f, String l, String u, String t);
	public String getEmail(String user);
}
