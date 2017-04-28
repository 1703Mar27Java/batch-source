package com.revature.database;

import com.revature.beans.Reimbursements;
import com.revature.beans.User;
import java.util.List;

public interface DataFacadeDAO {
	
	public User getUser(String userName);
	
	public String getUserPass(String userName);
	
	public boolean authenticate(User user, String pass);
	
	public void newReimbursement(Reimbursements r);
	
	public List<Reimbursements> getUsersReimbursements(int userID);
	
	public List<Reimbursements> getAllReimbursements();
	
	public List<Reimbursements> getFilteredReimbursements(int status);
	
	public void updateReimbursementsStatus(int resolverID,int reimbID,int status);

	void close() throws Exception;

	
	

}
