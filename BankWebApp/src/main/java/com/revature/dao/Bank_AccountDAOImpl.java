package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.revature.bean.Bank_Account;
import com.revature.util.ConnectionUtil;

public class Bank_AccountDAOImpl implements Bank_AccountDAO {

	@Override
	public List<Bank_Account> getAccounts(int userId) throws SQLException, IOException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM BANK_ACCOUNT WHERE BANK_USER_ID = ? ORDER BY BANK_ACCOUNT_ID ASC ";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, userId);
		List<Bank_Account> searchResults = new ArrayList<>();

		ResultSet result = stmt.executeQuery();

		while (result.next()) {
			Bank_Account temp = new Bank_Account();

			temp.setBANK_ACCOUNT_ID(result.getInt("BANK_ACCOUNT_ID"));
			temp.setBANK_USER_ID(result.getInt("BANK_USER_ID"));
			temp.setBANK_ACCOUNT_NAME(result.getString("BANK_ACCOUNT_NAME"));
			temp.setBANK_ACCOUNT_BALANCE(result.getDouble("BANK_ACCOUNT_BALANCE"));

			searchResults.add(temp);
		}

		if (result != null)
			result.close();
		if (stmt != null)
			stmt.close();

		return searchResults;
	}

	@Override
	public void createAccount(Bank_Account acc) throws SQLException, IOException {
		Connection connection = ConnectionUtil.getConnection();
		CallableStatement cs = null;

		try {
			cs = connection.prepareCall("{CALL SP_ACCOUNT_CREATE(?, ?)}");
			cs.setInt(1, acc.getBANK_USER_ID());
			cs.setString(2, acc.getBANK_ACCOUNT_NAME());

			cs.executeUpdate();

		} finally {
			if (cs != null)
				cs.close();
		}
	}

	@Override
	public void transaction(Bank_Account acc, double amount) throws SQLException, IOException {
		Connection connection = ConnectionUtil.getConnection();
		CallableStatement cs = null;

		try {
			cs = connection.prepareCall("{CALL SP_ACCOUNT_TRANSACTION(?, ?, ?)}");
			cs.setInt(1, acc.getBANK_ACCOUNT_ID());
			cs.setInt(2, acc.getBANK_USER_ID());
			cs.setDouble(3, amount);

			cs.executeUpdate();
		} finally {
			if (cs != null)
				cs.close();
		}
	}

	@Override
	public void updateAccount(Bank_Account acc) throws SQLException, IOException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "UPDATE BANK_ACCOUNT SET BANK_ACCOUNT_NAME = ? "
				+ "WHERE (BANK_ACCOUNT_ID = ? ) ";
		PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, acc.getBANK_ACCOUNT_NAME());
			stmt.setInt(2, acc.getBANK_ACCOUNT_ID());

			stmt.executeUpdate();
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	@Override
	public void deleteAccount(Bank_Account acc) throws SQLException, IOException {
		Connection connection = ConnectionUtil.getConnection();
		CallableStatement cs = null;

		try {
			cs = connection.prepareCall("{CALL SP_ACCOUNT_DELETE(?, ?)}");
			cs.setInt(1, acc.getBANK_ACCOUNT_ID());
			cs.setInt(2, acc.getBANK_USER_ID());

			cs.executeUpdate();
		} finally {
			if (cs != null)
				cs.close();
		}
	}
}
