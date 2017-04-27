package com.revature.dao;

import java.sql.*;
import java.util.*;

import com.revature.bean.ERS_USERS;

public interface ERS_USERSDAO {
	public List<ERS_USERS> loadAll() throws SQLException;
	
	public void create(ERS_USERS user) throws SQLException;

	public ERS_USERS search(String username, String password) throws SQLException;

	void save(ERS_USERS user) throws SQLException;
}