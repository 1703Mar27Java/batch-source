package com.revature.bankdao;

import com.revature.domain.Bank;

public interface BankDao {
	public void createUser(Bank user);
	public Bank logIn(String username, String password);
	
}
