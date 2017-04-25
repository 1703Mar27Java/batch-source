package com.Revature.dao;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;
import com.Revature.domain.Reimbursement;

public interface ReimbursementDAO {
	public void createReimbursement(Reimbursement r);
	public List<Reimbursement> filter(int userid, String filterType);
	public List<Reimbursement> unresolved(int userid);
	public List<Reimbursement> resolved(int userid);
}
