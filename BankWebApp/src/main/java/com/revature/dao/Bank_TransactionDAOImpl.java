package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.revature.bean.*;
import com.revature.util.ConnectionUtil;

public class Bank_TransactionDAOImpl implements Bank_TransactionDAO {

	@Override
	public List<Bank_Transaction> getTransactions(int userId) throws SQLException, IOException {
		Connection connection = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM BANK_TRANSACTION WHERE (BANK_USER_ID = ? ) " + "ORDER BY BANK_USER_ID ASC ";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, userId);
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
