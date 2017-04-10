package com.revature.domain;

import java.util.*;

import com.revature.dao.*;

public class Users {
	private int USER_ID;
	private String USER_NAME;
	private String PASSWORD;
	private List<Account> userAccounts = new ArrayList<>();
	private UsersDAOImp uDao = new UsersDAOImp();
	private AccountDAOImp aDao = new AccountDAOImp();

	public Users () {
		super();
	}
	
	public Users(String uSER_NAME, String pASSWORD) {
		this();
		USER_NAME = uSER_NAME;
		PASSWORD = pASSWORD;
	}
	
	public void createNewUser() {
		uDao.createUser(USER_NAME, PASSWORD);
		USER_ID = uDao.retrieveUserId(USER_NAME, PASSWORD);
	}
	
	public void retrieveUser() {
		USER_ID = uDao.retrieveUserId(USER_NAME, PASSWORD);
	}
	
	public void retrieveAccounts() {
		
	}
	
	public void updateName(String name) {
		USER_NAME = name;
		uDao.updateUser(USER_ID, 1, USER_NAME);
	}
	
	public void updatePassword(String pass) {
		PASSWORD = pass;
		uDao.updateUser(USER_ID, 2, pass);
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}
	
	public List<Account> getUserAccounts() {
		return userAccounts;
	}

	public void setUserAccounts(List<Account> userAccounts) {
		this.userAccounts = userAccounts;
	}
	
	public void viewAccounts() {
		userAccounts = uDao.retrieveAllAccounts(USER_ID);
		for (Account acc : userAccounts) {
			System.out.println(acc.toString());
		}
	}
	
	public void createAccount(String ACCOUNT_NAME) {
		Boolean valid = true;
		for (Account acc : userAccounts) {
			if (acc.getBANK_ACCOUNT_NAME() == ACCOUNT_NAME) {
				valid = false;
			}
		}
		if (valid) {
			Account newAccount = new Account(USER_ID, ACCOUNT_NAME, 0);			
			aDao.createAccount(USER_ID, newAccount.getBANK_ACCOUNT_NAME());
			newAccount.setBANK_ACCOUNT_ID(aDao.retrieveAccountId(USER_ID, ACCOUNT_NAME));
			userAccounts.add(newAccount);		
		}
	}
	
	public void deleteAccount(String ACCOUNT_NAME) {
		for (Account acc : userAccounts) {
			if (acc.getBANK_ACCOUNT_NAME().equalsIgnoreCase(ACCOUNT_NAME)) {
				if (acc.getBALANCE() != 0) {
					System.out.println("CANNOT DELETE ACCOUNT WITH NONZERO BALANCE");
				} else {
					aDao.deleteAccount(acc.getBANK_ACCOUNT_ID());
					userAccounts.remove(acc);
				}
				break;
			}
		}
	}
	
	public void depositAccount(String ACCOUNT_NAME, int deposit) {
		for (Account acc : userAccounts) {
			if (acc.getBANK_ACCOUNT_NAME().equalsIgnoreCase(ACCOUNT_NAME)) {
				aDao.updateBalance(acc.getBANK_ACCOUNT_ID(), (acc.getBALANCE()+deposit));
				System.out.println("You deposited $" + deposit);
			}
		}
	}
	
	public void withdrawAccount(String ACCOUNT_NAME, int withdraw) {
		for (Account acc : userAccounts) {
			if (acc.getBANK_ACCOUNT_NAME().equalsIgnoreCase(ACCOUNT_NAME)) {
				if (acc.getBALANCE() < withdraw) {
					System.out.println("CANNOT OVERDRAFT FROM THIS ACCOUNT");
				} else {
					aDao.updateBalance(acc.getBANK_ACCOUNT_ID(), (acc.getBALANCE()-withdraw));
					System.out.println("You withdrew $" + withdraw);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Users [USER_NAME=" + USER_NAME + ", PASSWORD=" + PASSWORD + "]";
	}
}
