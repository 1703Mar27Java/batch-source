package com.revature.database;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Reimbursements;
import com.revature.beans.ReimbursementsStatus;
import com.revature.beans.ReimbursementsType;

public interface ReimbursementsDAO {
	
	public void saveNewReimbursement(Reimbursements reim) throws SQLException;
	
	public List<Reimbursements> getUserReimbursements(int userID) throws SQLException;
	
	public List<Reimbursements> getAllReimbursements() throws SQLException;
	
	public List<Reimbursements> getFilteredReimbursements(int status) throws SQLException;
	
	public void updateReimbursementsStatus(int resID,int reimbID,int status) throws SQLException;
	
	public ReimbursementsStatus getStatus(int statusID) throws SQLException;
	
	public ReimbursementsType getType(int typeID) throws SQLException;
	
	

}
