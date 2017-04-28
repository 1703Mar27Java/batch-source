package com.revature.dao;

import java.sql.Blob;
import java.util.List;
import com.revature.domain.ReimbursementBackBean;

public interface ReimbursementDAO 
{
	public boolean createReim(ReimbursementBackBean reim, String filename);
	public ReimbursementBackBean getReimbursement(int id, String filename);
	public List<ReimbursementBackBean> getAllUserReimbursements(int userID, String filename);
	public List<ReimbursementBackBean> getAllReimbursements(String filename);
	public boolean updateReim(ReimbursementBackBean reim, String filename);
	public boolean deleteReim(int id, String filename);
	public List<String> getReimTypes(String filename);
	public int getTypeID(String type, String filename);
	public int getStatusID(String status, String filename);
	public Blob StringtoBlob(String receipt, String filename);
	public String getType(int typeID, String filename);
	public String getStatus(int statusID, String filename);
}
