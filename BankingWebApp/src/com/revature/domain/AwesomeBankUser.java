package com.revature.domain;

import java.util.*;
import com.revature.dao.*;

public class AwesomeBankUser {
	
	public AwesomeBankUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int userID;
	private String userName;
	private String password;
	private List<AwesomeBank> userAcc = new ArrayList<>();
	private AwesomeBankDaoImple dao=  new AwesomeBankDaoImple();
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<AwesomeBank> getUserAcc() {
		return userAcc;
	}
	public void setUserAcc(List<AwesomeBank> userAcc) {
		this.userAcc = userAcc;
	}
	public AwesomeBankDaoImple getDao() {
		return dao;
	}
	public void setDao(AwesomeBankDaoImple dao) {
		this.dao = dao;
	}
	@Override
	public String toString() {
		return "AwesomeBankUser [userID=" + userID + ", userName=" + userName + ", password=" + password + ", userAcc="
				+ userAcc + ", dao=" + dao + "]";
	}
	
	
	public void createNewUser() {
		dao.createUser(userName, password);
		userID = dao.retriveUserbyID(userName, password);
	}
	
	public void retriveUser(){
		userID = dao.retriveUserbyID(userName, password);
	}
	
	public void updateName(String updated){
		userName = updated;
		dao.updateU(userID, 1, updated);
	}
	public void updatePassword(String pass){
		password = pass;
		dao.updateU(userID, 2, pass);
	}
	
	public void viewAccounts(List<AwesomeBank> userAccounts)
	{
		userAccounts = dao.retriveAccounts(userID);
		for (AwesomeBank awesomeBank : userAccounts) {
				System.out.println(awesomeBank.toString());
			
		}
	}
	public void depositAccount(String accName,int deposit)
	{
		for(AwesomeBank c : userAcc)
		{
			if(c.getAccountName().equalsIgnoreCase(accName))
			{
				dao.updateBalance(c.getAccID(),(int) ((c.getAccBalance()+deposit)));
				System.out.println(c.getAccBalance());
			}
		}
	}
	
	

}
