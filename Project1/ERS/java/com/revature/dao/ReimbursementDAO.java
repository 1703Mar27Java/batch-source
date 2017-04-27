package com.revature.dao;

import java.util.ArrayList;

import com.revature.domain.Reimbursement;

public interface ReimbursementDAO {
	public void createReimbursement(Reimbursement reim, int author);
	public void updateReimbursement(Reimbursement reim, int resolver);
	public Reimbursement getReimbursementById(int id);	
	public ArrayList<Reimbursement> getReimbursements();
	public ArrayList<Reimbursement> getReimbursements(int id);
}
