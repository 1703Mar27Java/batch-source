package com.revature.dao;
import java.util.List;
import com.revature.domain.AwesomeBank;

public interface AwesomeBankDao {

//Account Manipulation
	public int createAccount(AwesomeBank awesome);
	public void updateAccount(AwesomeBank acc);
	public void createPassword(AwesomeBank acc);
	public void deleteAccount(int accID);
	
	public void logout(AwesomeBank acc);
	public void login(AwesomeBank acc); 
//Account Retrieval	
	public AwesomeBank retrieveAccountByID(int id);
	public AwesomeBank viewAccount(int id);
	public List<AwesomeBank> retieveAllAccounts();
	public float getAccountBalance(AwesomeBank acc);
	
//Money Manipulation
	public void depositMoney(AwesomeBank acc, float amount);
	public void withdrawMoney(AwesomeBank acc, float amount);
	

}