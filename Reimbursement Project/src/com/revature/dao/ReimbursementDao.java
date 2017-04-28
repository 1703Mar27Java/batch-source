package com.revature.dao;

import java.io.InputStream;

import com.revature.domain.Employee;
import com.revature.domain.Reimbursement;


public interface ReimbursementDao {

	public void createReimbursement(Employee employee, Reimbursement reimbursement, InputStream input);
	public void retreiveReimbursementById(Employee employee);
	public void updateReimbursement(Reimbursement reimbursement, int Resovler);
}