package com.revature.dao;

import java.sql.*;
import java.util.*;

import com.revature.bean.*;

public interface Bank_TransactionDAO {
	public List<Bank_Transaction> getTransactions(Connection conn, Bank_Transaction valueObject) throws SQLException;
}
