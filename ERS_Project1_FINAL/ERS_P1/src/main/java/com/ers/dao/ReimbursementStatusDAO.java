package com.ers.dao;

import com.ers.domain.ReimbursementStatus;

public interface ReimbursementStatusDAO {

	
	public void enterStatus(ReimbursementStatus status);
	
	public void retrieveStatus(ReimbursementStatus status);
	
}
