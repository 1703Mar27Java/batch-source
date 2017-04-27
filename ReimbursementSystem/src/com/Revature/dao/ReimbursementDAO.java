package com.Revature.dao;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;
import com.Revature.domain.Reimbursement;
import com.Revature.domain.SimpleReimb;

public interface ReimbursementDAO {
	public void createReimbursement(Reimbursement r);
	public List<SimpleReimb> filter(int userid, String filterType);
	public List<SimpleReimb> filter(String filterType);
	public List<SimpleReimb> allUnresolved();
	public List<SimpleReimb> allResolved();
	public List<SimpleReimb> unresolved(int userid);
	public List<SimpleReimb> resolved(int userid);
	public Reimbursement byId(int reimbursementID);
	public void approveReimb(int reimbursementID, int uid);
	public void denyReimb(int reimbursementID, int uid);
}
