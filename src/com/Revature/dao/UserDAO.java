package com.Revature.dao;

public interface UserDAO {
	public String createUser(String name, String pass);
	public String logIn(String name, String pass);
	public void addFunds(int bid, double money);
	public void subFunds(int bid, double money);
	public void createAcct(String uName, String acctName, double bal);
	public void deleteAcct(int bid);
	public void fetchAccts(String name);
	public void fetchAdmin();
	public void fetchTrans(String name);
	public void fetchTransAdmin();
}
