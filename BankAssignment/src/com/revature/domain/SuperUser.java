package com.revature.domain;

import java.util.*;

import com.revature.dao.*;

public class SuperUser extends Users {
	private UsersDAOImp uDao = new UsersDAOImp();
	List<Users> users;
	
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
}
