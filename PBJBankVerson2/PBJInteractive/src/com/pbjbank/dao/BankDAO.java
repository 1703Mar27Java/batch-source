package com.pbjbank.dao;



import java.util.List;

import com.pbjbank.domain.*;

	public interface BankDAO {
		
		
		
	//	public void createBankAccount(BankAccount bankAccount);
		public void createBankAccountPS(BankAccount bankAccount);
		public BankAccount retrieveBankById(int bankID);
		public List<BankAccount> retrieveAllBankAccounts();
		public void updateBank(BankAccount bankAccount);
		public void deleteBank(int bankID);
		//public void executeHelloWorld();
		
		

	}


