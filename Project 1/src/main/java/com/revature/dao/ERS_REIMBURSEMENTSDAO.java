package com.revature.dao;

import java.sql.*;
import java.util.*;
import com.revature.bean.ERS_REIMBURSEMENTS;

public interface ERS_REIMBURSEMENTSDAO {
	public List<ERS_REIMBURSEMENTS> loadAll() throws SQLException;

	public void create(ERS_REIMBURSEMENTS reimb) throws SQLException;

	public void update(ERS_REIMBURSEMENTS reimb) throws SQLException;

	void resolve(int id, String status, int manager);

	void submit(double amt, String desc, int id, String type);
}