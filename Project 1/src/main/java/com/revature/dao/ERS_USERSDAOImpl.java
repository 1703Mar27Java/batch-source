package com.revature.dao;

import java.sql.*;
import java.util.*;

import com.revature.bean.ERS_USERS;
import com.revature.util.ConnectionUtil;

public class ERS_USERSDAOImpl implements ERS_USERSDAO {

	@Override
	public List<ERS_USERS> loadAll() throws SQLException {
		PreparedStatement stmt = null;
		ResultSet result = null;
		String sql = "SELECT * FROM ERS_USERS WHERE UR_ID = ? ORDER BY U_ID ASC ";
		List<ERS_USERS> searchResults = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 2);
			result = stmt.executeQuery();

			while (result.next()) {
				ERS_USERS temp = new ERS_USERS();

				temp.setU_ID(result.getInt("U_ID"));
				temp.setU_USERNAME(result.getString("U_USERNAME"));
				temp.setU_PASSWORD(result.getString("U_PASSWORD"));
				temp.setU_FIRSTNAME(result.getString("U_FIRSTNAME"));
				temp.setU_LASTNAME(result.getString("U_LASTNAME"));
				temp.setU_EMAIL(result.getString("U_EMAIL"));
				temp.setUR_ID(result.getInt("UR_ID"));

				searchResults.add(temp);
			}

		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}

		return searchResults;
	}

	@Override
	public void create(ERS_USERS user) throws SQLException {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "";
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			sql = "INSERT INTO ERS_USERS ( U_USERNAME, U_PASSWORD, U_FIRSTNAME, "
					+ "U_LASTNAME, U_EMAIL, UR_ID) VALUES (?, ?, ?, ?, ?, ?) ";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, user.getU_USERNAME());
			stmt.setString(2, user.getU_PASSWORD());
			stmt.setString(3, user.getU_FIRSTNAME());
			stmt.setString(4, user.getU_LASTNAME());
			stmt.setString(5, user.getU_EMAIL());
			stmt.setInt(6, user.getUR_ID());

			int rowcount = stmt.executeUpdate();
			if (rowcount != 1) {
				throw new SQLException("PrimaryKey Error when updating DB!");
			}

		} finally {
			if (stmt != null)
				stmt.close();
		}

		sql = "SELECT SQ_ERS_USERS_PK.currval FROM dual";

		try {
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();

			if (result.next()) {
				user.setU_ID((int) result.getLong(1));
			} else {
				throw new SQLException("Unable to find primary-key for created object!");
			}
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}
	}

	@Override
	public ERS_USERS search(String username, String password) throws SQLException {
		ERS_USERS searchResults = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		String sql = "";

		try (Connection conn = ConnectionUtil.getConnection()) {
			sql += "SELECT * FROM ERS_USERS WHERE 1=1 ";
			sql += "AND U_USERNAME = ? ";
			sql += "AND U_PASSWORD = ? ";
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, username);
			stmt.setString(2, password);
			result = stmt.executeQuery();

			if (result.next()) {
				searchResults = new ERS_USERS();
				searchResults.setU_ID(result.getInt("U_ID"));
				searchResults.setU_USERNAME(result.getString("U_USERNAME"));
				searchResults.setU_PASSWORD(result.getString("U_PASSWORD"));
				searchResults.setU_FIRSTNAME(result.getString("U_FIRSTNAME"));
				searchResults.setU_LASTNAME(result.getString("U_LASTNAME"));
				searchResults.setU_EMAIL(result.getString("U_EMAIL"));
				searchResults.setUR_ID(result.getInt("UR_ID"));
			} else {
				throw new SQLException("Incorrect username or password!");
			}

		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}

		return searchResults;
	}

	@Override
	public void save(ERS_USERS user) throws SQLException {
		String sql = "UPDATE ERS_USERS SET U_USERNAME = ?, U_PASSWORD = ?, U_FIRSTNAME = ?, "
				+ "U_LASTNAME = ?, U_EMAIL = ? WHERE (U_ID = ? ) ";
		PreparedStatement stmt = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getU_USERNAME());
			stmt.setString(2, user.getU_PASSWORD());
			stmt.setString(3, user.getU_FIRSTNAME());
			stmt.setString(4, user.getU_LASTNAME());
			stmt.setString(5, user.getU_EMAIL());

			stmt.setInt(6, user.getU_ID());

			int rowcount = stmt.executeUpdate();
			if (rowcount == 0) {
				throw new SQLException("Object could not be saved! (PrimaryKey not found)");
			}
			if (rowcount > 1) {
				throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
			}
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}
}