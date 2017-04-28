package com.revature.dao;

import java.util.List;

import com.revature.domain.Reimbursement;

public interface ReimbursementDao {
	public void createReimbursement(Reimbursement rei);
	public Reimbursement retrieveReimbursementById(int rid);
	public List<Reimbursement> retrieveUserReimbursementByUserId(int uid);
	public List<Reimbursement> retrieveReimbursements();
	public void updateReimbursement(int rei, int appr);
	public void deleteReimbursement(int id);
}
