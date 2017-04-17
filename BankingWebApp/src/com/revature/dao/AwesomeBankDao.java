package com.revature.dao;
import java.util.List;
import com.revature.domain.AwesomeBank;
import com.revature.domain.AwesomeBankUser;

public interface AwesomeBankDao {

//Account Manipulation
	public void createAccount(String accName, int id);
	public void updateAccount(int id, String update);
	public void deleteAccount(int accID);
	public void updateBalance(int id,int uBalance);
	public void withdraw(int id, int with);
	public void deposit(int id, int depo );
	
//Account Retrieval	
	public int retrieveAccountByID(int id, String accName);
	public AwesomeBank viewAccount(int id);
	public List<AwesomeBank> retriveAccounts(int id);

	
//User Manipulation
	public void createUser(String name,String pass);
	public int retriveUserbyID(String name,String pass);
	public List<AwesomeBankUser> retriveUsers();
	public void updateU(int id, int choice, String update);
	public void deleteUser(int id);
	
	public String logIn(String name,String pass);
	

}