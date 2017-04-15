package com.revature.dao;

import java.sql.*;
import java.util.*;

import com.revature.domain.Bank_User;
import com.revature.exception.NotFoundException;

public class Bank_UserDAOImpl implements Bank_UserDAO {

	@Override
	public Bank_User createValueObject() {
		return new Bank_User();
	}

	@Override
	public Bank_User getObject(Connection conn, int BANK_USER_ID) 
			throws NotFoundException, SQLException {
		Bank_User valueObject = createValueObject();
        valueObject.setBANK_USER_ID(BANK_USER_ID);
        load(conn, valueObject);
        return valueObject;
	}

	@Override
	public void load(Connection conn, Bank_User valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM BANK_USER WHERE (BANK_USER_ID = ? ) "; 
        PreparedStatement stmt = null;

        try {
             stmt = conn.prepareStatement(sql);
             stmt.setInt(1, valueObject.getBANK_USER_ID()); 

             singleQuery(conn, stmt, valueObject);

        } finally {
            if (stmt != null)
                stmt.close();
        }
	}

	@Override
	public List<Bank_User> loadAll(Connection conn) throws SQLException {
		String sql = "SELECT * FROM BANK_USER ORDER BY BANK_USER_ID ASC ";
        List<Bank_User> searchResults = listQuery(conn, conn.prepareStatement(sql));

        return searchResults;
	}

	@SuppressWarnings("unused")
	@Override
	public void create(Connection conn, Bank_User valueObject) throws SQLException {
		String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;

        try {
             sql = "INSERT INTO BANK_USER ( BANK_USER_ID, BANK_USER_NAME, BANK_USER_PASSWORD) "
             		+ "VALUES (?, ?, ?) ";
             stmt = conn.prepareStatement(sql);

             stmt.setInt(1, valueObject.getBANK_USER_ID()); 
             stmt.setString(2, valueObject.getBANK_USER_NAME()); 
             stmt.setString(3, valueObject.getBANK_USER_PASSWORD()); 

             int rowcount = databaseUpdate(conn, stmt);
             if (rowcount != 1) {
                  //System.out.println("PrimaryKey Error when updating DB!");
                  throw new SQLException("PrimaryKey Error when updating DB!");
             }

        } finally {
            if (stmt != null)
                stmt.close();
        }
	}

	@Override
	public void save(Connection conn, Bank_User valueObject) throws NotFoundException, SQLException {
		String sql = "UPDATE BANK_USER SET BANK_USER_NAME = ?, "
				+ "BANK_USER_PASSWORD = ? WHERE (BANK_USER_ID = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, valueObject.getBANK_USER_NAME()); 
            stmt.setString(2, valueObject.getBANK_USER_PASSWORD()); 

            stmt.setInt(3, valueObject.getBANK_USER_ID()); 

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                 //System.out.println("Object could not be saved! (PrimaryKey not found)");
                 throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                 //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                 throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
	}

	@Override
	public void delete(Connection conn, Bank_User valueObject) throws NotFoundException, SQLException {
		String sql = "DELETE FROM BANK_USER WHERE (BANK_USER_ID = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getBANK_USER_ID()); 

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                 //System.out.println("Object could not be deleted (PrimaryKey not found)");
                 throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                 //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                 throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
	}

	@SuppressWarnings("unused")
	@Override
	public void deleteAll(Connection conn) throws SQLException {
		String sql = "DELETE FROM BANK_USER";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            int rowcount = databaseUpdate(conn, stmt);
        } finally {
            if (stmt != null)
                stmt.close();
        }
	}
	
	@Override
	public int countAll(Connection conn) throws SQLException {

		String sql = "SELECT COUNT(*) FROM BANK_USER";
		PreparedStatement stmt = null;
		ResultSet result = null;
		int allRows = 0;

		try {
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();

			if (result.next())
				allRows = result.getInt(1);
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}
		return allRows;
	}
	
	@Override
	public List<Bank_User> searchMatching(Connection conn, Bank_User valueObject) throws SQLException {

		List<Bank_User> searchResults;

		boolean first = true;
		StringBuffer sql = new StringBuffer("SELECT * FROM BANK_USER WHERE 1=1 ");

		if (valueObject.getBANK_USER_ID() != 0) {
			if (first) {
				first = false;
			}
			sql.append("AND BANK_USER_ID = ").append(valueObject.getBANK_USER_ID()).append(" ");
		}

		if (valueObject.getBANK_USER_NAME() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND BANK_USER_NAME LIKE '").append(valueObject.getBANK_USER_NAME()).append("%' ");
		}

		if (valueObject.getBANK_USER_PASSWORD() != null) {
			if (first) {
				first = false;
			}
			sql.append("AND BANK_USER_PASSWORD LIKE '").append(valueObject.getBANK_USER_PASSWORD()).append("%' ");
		}

		sql.append("ORDER BY BANK_USER_ID ASC ");

		// Prevent accidental full table results.
		// Use loadAll if all rows must be returned.
		if (first)
			searchResults = new ArrayList<>();
		else
			searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

		return searchResults;
	}

	@Override
	public int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {
		int result = stmt.executeUpdate();

        return result;
	}

	@Override
	public void singleQuery(Connection conn, PreparedStatement stmt, Bank_User valueObject)
			throws NotFoundException, SQLException {
		ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                 valueObject.setBANK_USER_ID(result.getInt("BANK_USER_ID")); 
                 valueObject.setBANK_USER_NAME(result.getString("BANK_USER_NAME")); 
                 valueObject.setBANK_USER_PASSWORD(result.getString("BANK_USER_PASSWORD")); 

            } else {
                  //System.out.println("Users Object Not Found!");
                  throw new NotFoundException("User Object Not Found!");
            }
        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }

	}

	@Override
	public List<Bank_User> listQuery(Connection conn, PreparedStatement stmt) throws SQLException {
		ArrayList<Bank_User> searchResults = new ArrayList<>();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                 Bank_User temp = createValueObject();

                 temp.setBANK_USER_ID(result.getInt("BANK_USER_ID")); 
                 temp.setBANK_USER_NAME(result.getString("BANK_USER_NAME")); 
                 temp.setBANK_USER_PASSWORD(result.getString("BANK_USER_PASSWORD")); 

                 searchResults.add(temp);
            }

        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }

        return (List<Bank_User>)searchResults;
	}

}
