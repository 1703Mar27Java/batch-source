package com.revature.dao;

import java.sql.*;
import java.util.*;
import com.revature.bean.ERS_REIMBURSEMENTS;

public interface ERS_REIMBURSEMENTSDAO {
	public List<ERS_REIMBURSEMENTS> loadAll() throws SQLException;

	public void create(ERS_REIMBURSEMENTS reimb) throws SQLException;

	void submit(double amt, String desc, int id, int type) throws SQLException;

	void resolve(int id, int status, int manager);

	public void update(ERS_REIMBURSEMENTS reimb) throws SQLException;
}