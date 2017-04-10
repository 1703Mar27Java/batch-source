package com.revature.domain;

import java.util.*;

import com.revature.dao.*;

public class SuperUser extends Users {
	List<Users> users;
	private UsersDAOImp uDao = new UsersDAOImp();
	private String USER_NAME;

	public SuperUser () {
		super();
	}
	
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	
	public String getUSER_NAME() {
		return USER_NAME;
	}
	
	public void createNewUser(String userName, String password) {
		uDao.createUser(userName, password);
	}
	
	public void retrieveAll() {
		users = uDao.retrieveAllUsers();
	}
	
	public void updateAnyName(String userName, String newName) {
		uDao.updateAnyUserName(userName, newName);
	}
	
	public void updateAnyPassword(String oldPass, String newPass) {
		uDao.updateAnyUserPassword(oldPass, newPass);
	}
	
	public void deleteAny(String userName) {
		uDao.deleteAnyUser(userName);
	}

	@Override
	public String toString() {
		return "SuperUser [users=" + users + "]";
	}
}
