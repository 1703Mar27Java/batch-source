package com.pbjbank.dao;

import java.util.List;

import com.pbjbank.domain.BankAccount;
import com.pbjbank.domain.User_Logon;

	public interface BankDAO {
		
		public void userInput();
		
		public void createBankAccount(BankAccount bankAccount);
		public void createBankAccountPS(BankAccount bankAccount);
		public BankAccount retrieveBankById(int bankID);
		public List<BankAccount> retrieveAllBankAccounts();
		public void updateBank(BankAccount bankAccount);
		public void deleteBank(int bankID);
		//public void executeHelloWorld();
		
		public void createNewUser(User_Logon userLogon);
		public void createNewUserPS(User_Logon userLogon);
		public User_Logon retrieveUserName(String userName);
		public List<User_Logon> retrieveAllUser_Logons();
		public void updateLogon(User_Logon userLogon);
		public void deleteLogon(String userName);
		
		

	}


