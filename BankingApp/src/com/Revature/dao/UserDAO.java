package com.Revature.dao;

import java.util.ArrayList;

import com.Revature.beans.BankAcct;
import com.Revature.beans.Trans;

public interface UserDAO {
	public String createUser(String name, String pass);
	public String logIn(String name, String pass);
	public void addFunds(int bid, double money);
	public void subFunds(int bid, double money);
	public void createAcct(String uName, String acctName, double bal);
	public void deleteAcct(int bid);
	public ArrayList<BankAcct> fetchAccts(String name);
	public ArrayList<BankAcct> fetchAdmin();
	public ArrayList<Trans> fetchTrans(String name);
	public ArrayList<Trans> fetchTransAdmin();
	
	public String getUserOfBankAcct(int bid); 
}
