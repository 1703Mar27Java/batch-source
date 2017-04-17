package com.revature.dao;

import java.sql.*;
import java.util.*;

import com.revature.bean.*;

public class Bank_TransactionDAOImpl implements Bank_TransactionDAO {

	@Override
	public List<Bank_Transaction> getTransactions(Connection conn, Bank_Transaction valueObject) throws SQLException {
		String sql = "SELECT * FROM BANK_TRANSACTION WHERE (BANK_USER_ID = ? ) " + "ORDER BY BANK_USER_ID ASC ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, valueObject.getBANK_USER_ID());
		List<Bank_Transaction> searchResults = new ArrayList<>();
		ResultSet result = stmt.executeQuery();

		while (result.next()) {
			Bank_Transaction temp = new Bank_Transaction();

			temp.setBANK_TRANSACTION_ID(result.getInt("BANK_TRANSACTION_ID"));
			temp.setBANK_USER_ID(result.getInt("BANK_USER_ID"));
			temp.setBANK_TRANSACTION_DESC(result.getString("BANK_TRANSACTION_DESC"));

			searchResults.add(temp);
		}

		if (result != null)
			result.close();
		if (stmt != null)
			stmt.close();

		return searchResults;
	}

}
