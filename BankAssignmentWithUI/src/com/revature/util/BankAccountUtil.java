package com.revature.util;

import java.io.File;
import java.util.*;

import com.revature.dao.BankAccountDAOImpl;
import com.revature.domain.BankAccount;

public class BankAccountUtil 
{
	private static final String filename = new File("C:\\Revature\\BankAssignmentWithUI\\connection.properties").getAbsolutePath();

	public static BankAccount retrieveBankAcctHelper(int acctID)
	{
		BankAccount acct = new BankAccount();
		BankAccountDAOImpl dao = new BankAccountDAOImpl();
		acct = dao.retrieveAccount(acctID, filename);
		return acct;
	}
	
	public static boolean isAnAccount(int acctID)
	{
		BankAccountDAOImpl dao = new BankAccountDAOImpl();
		return(dao.retrieveAccount(acctID, filename).getAccountID() != 0);
	}

	public static boolean depositHelper(int acctID, double amount)
	{
		BankAccountDAOImpl dao = new BankAccountDAOImpl();
		return dao.deposit(acctID, amount, filename);
	}
	
	public static boolean validWithdrawal(int acctID, double amount)
	{
		BankAccountDAOImpl dao = new BankAccountDAOImpl();
		BankAccount account = new BankAccount();
		account = dao.retrieveAccount(acctID, filename);
		
		return !((account.getBalance() - amount) < 0);
	}

	public static boolean withdrawalHelper(int acctID, double amount)
	{
		BankAccountDAOImpl dao = new BankAccountDAOImpl();
		return dao.withdrawal(acctID, amount, filename);	
	}
	
	public static boolean validDelete(int acctID)
	{
		BankAccountDAOImpl dao = new BankAccountDAOImpl();
		BankAccount account = new BankAccount();
		account = dao.retrieveAccount(acctID, filename);
		
		return (account.getBalance() == 0);
	}
	
	public static boolean deleteAccountHelper(int acctID)
	{
		BankAccountDAOImpl dao = new BankAccountDAOImpl();
		return dao.deleteAccount(acctID, filename);
	}
	
	public static List<BankAccount> getAccounts(int userID)
	{
		BankAccountDAOImpl dao = new BankAccountDAOImpl();
		ArrayList<BankAccount> bankAccts = new ArrayList<BankAccount>();
		bankAccts = (ArrayList<BankAccount>)dao.viewAccounts(userID, filename);
		return bankAccts;
	}
	
	public static boolean createAcctNameValid(int userID, String acctName)
	{
		ArrayList<BankAccount> bankAccts = (ArrayList<BankAccount>)BankAccountUtil.getAccounts(userID);
		
		for(BankAccount acct: bankAccts)
		{
			if (acct.getAccountName().equals(acctName)) return false;
		}
		
		return true;
	}
	
	
	public static boolean createAccountHelper(int userID, String acctName, double initBal)
	{
		BankAccountDAOImpl dao = new BankAccountDAOImpl();
		
		BankAccount newAccount = new BankAccount();
		newAccount.setAccountName(acctName);
		newAccount.setBalance(initBal);
		newAccount.setUserID(userID);
		
		return dao.createAccount(newAccount, filename);
	}
}
