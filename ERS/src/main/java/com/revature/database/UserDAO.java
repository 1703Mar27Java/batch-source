package com.revature.database;


import java.sql.SQLException;
import com.revature.beans.User;

public interface UserDAO {
	
	public User getUserbyID(int userID) throws SQLException;
	public User getUserByName(String userName) throws SQLException;
	public String getUserPassword(String username) throws SQLException;
	
	

}
