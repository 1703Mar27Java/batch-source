package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import com.revature.bean.Bank_Account;

public interface Bank_AccountDAO {
	public List<Bank_Account> getAccounts(int userId) throws SQLException, IOException;
	public void createAccount(Bank_Account acc) throws SQLException, IOException;
	public void transaction(Bank_Account acc, double amount) throws SQLException, IOException;
	public void updateAccount(Bank_Account acc) throws SQLException, IOException;
	public void deleteAccount(Bank_Account acc) throws SQLException, IOException;
}
