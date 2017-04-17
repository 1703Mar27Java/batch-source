package com.revature.dao;

import java.sql.*;
import java.util.*;

import com.revature.bean.Bank_Account;

public class Bank_AccountDAOImpl implements Bank_AccountDAO {

	@Override
	public List<Bank_Account> getAccounts(Connection conn, Bank_Account valueObject) throws SQLException {
		String sql = "SELECT * FROM BANK_ACCOUNT WHERE BANK_USER_ID = ? ORDER BY BANK_ACCOUNT_ID ASC ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, valueObject.getBANK_USER_ID());
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
	public void createAccount(Connection conn, Bank_Account valueObject) throws SQLException {
		CallableStatement cs = null;

		try {
			cs = conn.prepareCall("{CALL SP_ACCOUNT_CREATE(?, ?)}");
			cs.setInt(1, valueObject.getBANK_USER_ID());
			cs.setString(2, valueObject.getBANK_ACCOUNT_NAME());

			cs.executeUpdate();

		} finally {
			if (cs != null)
				cs.close();
		}
	}

	@Override
	public void transaction(Connection conn, Bank_Account valueObject, double amount) throws SQLException {
		CallableStatement cs = null;

		try {
			cs = conn.prepareCall("{CALL SP_ACCOUNT_TRANSACTION(?, ?, ?)}");
			cs.setInt(1, valueObject.getBANK_ACCOUNT_ID());
			cs.setInt(2, valueObject.getBANK_USER_ID());
			cs.setDouble(3, amount);

			cs.executeUpdate();
		} finally {
			if (cs != null)
				cs.close();
		}
	}

	@Override
	public void updateAccount(Connection conn, Bank_Account valueObject) throws SQLException {
		String sql = "UPDATE BANK_ACCOUNT SET BANK_USER_ID = ?, BANK_ACCOUNT_NAME = ?, "
				+ "BANK_ACCOUNT_BALANCE = ? WHERE (BANK_ACCOUNT_ID = ? ) ";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, valueObject.getBANK_USER_ID());
			stmt.setString(2, valueObject.getBANK_ACCOUNT_NAME());
			stmt.setDouble(3, valueObject.getBANK_ACCOUNT_BALANCE());

			stmt.setInt(4, valueObject.getBANK_ACCOUNT_ID());

			stmt.executeUpdate();
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}

	@Override
	public void deleteAccount(Connection conn, Bank_Account valueObject) throws SQLException {
		CallableStatement cs = null;

		try {
			cs = conn.prepareCall("{CALL SP_ACCOUNT_DELETE(?, ?)}");
			cs.setInt(1, valueObject.getBANK_ACCOUNT_ID());
			cs.setInt(2, valueObject.getBANK_USER_ID());

			cs.executeUpdate();
		} finally {
			if (cs != null)
				cs.close();
		}
	}
}
