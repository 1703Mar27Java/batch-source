package com.revature.dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.revature.bean.*;

public interface Bank_TransactionDAO {
	public List<Bank_Transaction> getTransactions(int userId) throws SQLException, IOException;
}
