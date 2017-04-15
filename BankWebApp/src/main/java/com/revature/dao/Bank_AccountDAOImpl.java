package com.revature.dao;

import java.sql.*;
import java.util.*;

import com.revature.domain.Bank_Account;
import com.revature.exception.NotFoundException;

public class Bank_AccountDAOImpl implements Bank_AccountDAO {

	@Override
	public Bank_Account createValueObject() {
		return new Bank_Account();
	}

	@Override
	public Bank_Account getObject(Connection conn, int BANK_ACCOUNT_ID) throws NotFoundException, SQLException {
		Bank_Account valueObject = createValueObject();
        valueObject.setBANK_ACCOUNT_ID(BANK_ACCOUNT_ID);
        load(conn, valueObject);
        return valueObject;
	}

	@Override
	public void load(Connection conn, Bank_Account valueObject) throws NotFoundException, SQLException {
		String sql = "SELECT * FROM BANK_ACCOUNT WHERE (BANK_ACCOUNT_ID = ? ) "; 
        PreparedStatement stmt = null;

        try {
             stmt = conn.prepareStatement(sql);
             stmt.setInt(1, valueObject.getBANK_ACCOUNT_ID()); 

             singleQuery(conn, stmt, valueObject);

        } finally {
            if (stmt != null)
                stmt.close();
        }
	}

	@Override
	public List<Bank_Account> loadAll(Connection conn, Bank_Account valueObject) throws SQLException {
		String sql = "SELECT * FROM BANK_ACCOUNT WHERE BANK_USER_ID = ? ORDER BY BANK_ACCOUNT_ID ASC ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, valueObject.getBANK_USER_ID());
        List<Bank_Account> searchResults = listQuery(conn, stmt);

        return searchResults;
	}

	@Override
	public void create(Connection conn, Bank_Account valueObject) throws SQLException {
		CallableStatement cs = null;

        try {
			cs = conn.prepareCall("{CALL SP_ACCOUNT_CREATE(?, ?)}");
			cs.setInt(1, valueObject.getBANK_USER_ID());
			cs.setString(2, valueObject.getBANK_ACCOUNT_NAME());
			
            int rowcount = databaseUpdate(conn, cs);
            if (rowcount != 1) {
                 //System.out.println("PrimaryKey Error when updating DB!");
                 throw new SQLException("PrimaryKey Error when updating DB!");
            }

        } finally {
			if (cs != null) 
				cs.close();
		}
	}
	
	@Override
	public void transaction(Connection conn, Bank_Account valueObject, double amount) throws NotFoundException, SQLException {
		CallableStatement cs = null;
		
		try {
			cs = conn.prepareCall("{CALL SP_ACCOUNT_TRANSACTION(?, ?, ?)}");
			cs.setInt(1, valueObject.getBANK_ACCOUNT_ID());
			cs.setInt(2, valueObject.getBANK_USER_ID());
			cs.setDouble(3, amount);
			
            int rowcount = databaseUpdate(conn, cs);
            if (rowcount == 0) {
                //System.out.println("Object could not be saved! (PrimaryKey not found)");
                throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
            }

        } finally {
			if (cs != null) 
				cs.close();
		}
	}

	@Override
	public void save(Connection conn, Bank_Account valueObject) throws NotFoundException, SQLException {
		String sql = "UPDATE BANK_ACCOUNT SET BANK_USER_ID = ?, BANK_ACCOUNT_NAME = ?, "
				+ "BANK_ACCOUNT_BALANCE = ? WHERE (BANK_ACCOUNT_ID = ? ) ";
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getBANK_USER_ID()); 
            stmt.setString(2, valueObject.getBANK_ACCOUNT_NAME()); 
            stmt.setDouble(3, valueObject.getBANK_ACCOUNT_BALANCE()); 

            stmt.setInt(4, valueObject.getBANK_ACCOUNT_ID()); 

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
	public void delete(Connection conn, Bank_Account valueObject) throws NotFoundException, SQLException {
        CallableStatement cs = null;
		
		try {
			cs = conn.prepareCall("{CALL SP_ACCOUNT_DELETE(?, ?)}");
			cs.setInt(1, valueObject.getBANK_ACCOUNT_ID());
			cs.setInt(2, valueObject.getBANK_USER_ID());

            int rowcount = databaseUpdate(conn, cs);
            if (rowcount == 0) {
                 //System.out.println("Object could not be deleted (PrimaryKey not found)");
                 throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
            }
            if (rowcount > 1) {
                 //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                 throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
            }
        } finally {
            if (cs != null)
                cs.close();
        }
	}

	@SuppressWarnings("unused")
	@Override
	public void deleteAll(Connection conn) throws SQLException {
		String sql = "DELETE FROM BANK_ACCOUNT";
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
		String sql = "SELECT COUNT(*) FROM BANK_ACCOUNT";
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
	public List<Bank_Account> searchMatching(Connection conn, Bank_Account valueObject) throws SQLException {
		List<Bank_Account> searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM BANK_ACCOUNT WHERE 1=1 ");

        if (valueObject.getBANK_ACCOUNT_ID() != 0) {
            if (first) { first = false; }
            sql.append("AND BANK_ACCOUNT_ID = ").append(valueObject.getBANK_ACCOUNT_ID()).append(" ");
        }

        if (valueObject.getBANK_USER_ID() != 0) {
            if (first) { first = false; }
            sql.append("AND BANK_USER_ID = ").append(valueObject.getBANK_USER_ID()).append(" ");
        }

        if (valueObject.getBANK_ACCOUNT_NAME() != null) {
            if (first) { first = false; }
            sql.append("AND BANK_ACCOUNT_NAME LIKE '").append(valueObject.getBANK_ACCOUNT_NAME()).append("%' ");
        }

        if (valueObject.getBANK_ACCOUNT_BALANCE() != 0) {
            if (first) { first = false; }
            sql.append("AND BANK_ACCOUNT_BALANCE = ").append(valueObject.getBANK_ACCOUNT_BALANCE()).append(" ");
        }


        sql.append("ORDER BY BANK_ACCOUNT_ID ASC ");

        // Prevent accidental full table results.
        // Use loadAll if all rows must be returned.
        if (first)
             searchResults = new ArrayList<Bank_Account>();
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
	public int databaseUpdate(Connection conn, CallableStatement cs) throws SQLException {
		int result = cs.executeUpdate();
		
		return result;
	}

	@Override
	public void singleQuery(Connection conn, PreparedStatement stmt, Bank_Account valueObject)
			throws NotFoundException, SQLException {
		ResultSet result = null;

        try {
            result = stmt.executeQuery();

            if (result.next()) {

                 valueObject.setBANK_ACCOUNT_ID(result.getInt("BANK_ACCOUNT_ID")); 
                 valueObject.setBANK_USER_ID(result.getInt("BANK_USER_ID")); 
                 valueObject.setBANK_ACCOUNT_NAME(result.getString("BANK_ACCOUNT_NAME")); 
                 valueObject.setBANK_ACCOUNT_BALANCE(result.getDouble("BANK_ACCOUNT_BALANCE")); 

            } else {
                  //System.out.println("Bank_Account Object Not Found!");
                  throw new NotFoundException("BANK_ACCOUNT Object Not Found!");
            }
        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }
	}

	@Override
	public List<Bank_Account> listQuery(Connection conn, PreparedStatement stmt) throws SQLException {
		ArrayList<Bank_Account> searchResults = new ArrayList<>();
        ResultSet result = null;

        try {
            result = stmt.executeQuery();

            while (result.next()) {
                 Bank_Account temp = createValueObject();

                 temp.setBANK_ACCOUNT_ID(result.getInt("BANK_ACCOUNT_ID")); 
                 temp.setBANK_USER_ID(result.getInt("BANK_USER_ID")); 
                 temp.setBANK_ACCOUNT_NAME(result.getString("BANK_ACCOUNT_NAME")); 
                 temp.setBANK_ACCOUNT_BALANCE(result.getDouble("BANK_ACCOUNT_BALANCE")); 

                 searchResults.add(temp);
            }

        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }

        return (List<Bank_Account>)searchResults;
	}

}
