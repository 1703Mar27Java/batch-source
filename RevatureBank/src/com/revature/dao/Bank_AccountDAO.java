package com.revature.dao;

import java.sql.*;
import java.util.List;

import com.revature.bean.Bank_Account;

public interface Bank_AccountDAO {
	public List<Bank_Account> getAccounts(Connection conn, Bank_Account valueObject) throws SQLException;
	public void createAccount(Connection conn, Bank_Account valueObject) throws SQLException;
	public void transaction(Connection conn, Bank_Account valueObject, double amount) 
			throws SQLException;
	public void updateAccount(Connection conn, Bank_Account valueObject) 
			throws SQLException;
	public void deleteAccount(Connection conn, Bank_Account valueObject) 
			throws SQLException;
}
