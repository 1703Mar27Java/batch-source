package com.revature.Dao;

import java.util.List;

import com.revature.Domain.Bank;
import com.revature.Domain.User;

public interface BankDao {

	public void creatBankAccount(Bank bank, User user);

	public void depositBankAccount(Bank bank, User user, float amount);

	public void withdralBankAccount(Bank bank, User user, float amount);

	public List<Bank> retrieveBankAccounts(Bank bank, User user);

	public void deleteBankAccount(Bank bank, User user);
}
