package com.revature.util;

import java.util.ArrayList;

import com.revature.bankExceptions.AccountAlreadyExistsException;
import com.revature.bankExceptions.AccountDoesntExistsException;
import com.revature.bankExceptions.BankBalanceException;
import com.revature.dao.BankDAOImp;
import com.revature.domain.Account;
import com.revature.domain.Transaction;
import com.revature.domain.User;

public class AccountUtil {

	public static void listAccounts(User user) {
		ArrayList<Account> accounts = user.getAccounts();

		if (accounts.isEmpty()) {
			System.out.println("You currently have no accounts set up");
		} else {
			System.out.println("You have " + accounts.size() + " account(s):\n");
			for (Account a : accounts) {
				System.out.println(a.getName() + " - $" + a.getBalance());
			}
		}
	}

	public static void tryDelete(User user, String accountName)
			throws AccountDoesntExistsException, BankBalanceException {
		BankDAOImp dao = new BankDAOImp();
		Account account = user.getAccount(accountName);
		if (account != null) {
			if (account.getBalance() == 0) {
				dao.deleteAccount(user, account);
				System.out.println("\nAccount '" + accountName + "' successfully deleted\n");
				dao.getAccounts(user);
			} else {
				throw new BankBalanceException("Account must be empty in order to be deleted");
			}
		} else {
			throw new AccountDoesntExistsException("No account exists by that name");
		}
	}

	public static void tryCreate(User user, String accountName) throws AccountAlreadyExistsException {
		BankDAOImp dao = new BankDAOImp();
		Account account = user.getAccount(accountName);
		if (account == null) {
			dao.createAccount(user, new Account(accountName, 0));
			System.out.println("\nAccount '" + accountName + "' successfully created\n");
			dao.getAccounts(user);
		} else {
			throw new AccountAlreadyExistsException("You already have an account that exists by that name");
		}
	}

	public static void deposit(User user, String accountName, int deposit) throws AccountDoesntExistsException {
		BankDAOImp dao = new BankDAOImp();
		Account account = user.getAccount(accountName);
		if (account != null) {
			dao.depositAccount(account, deposit);
			System.out.println("\nSuccessfully deposited $" + deposit + " into " + accountName);
			dao.getAccounts(user);
		} else {
			throw new AccountDoesntExistsException("No account exists by that name");
		}
	}

	public static void withdraw(User user, String accountName, int withdraw)
			throws AccountDoesntExistsException, BankBalanceException {
		BankDAOImp dao = new BankDAOImp();
		Account account = user.getAccount(accountName);
		if (account != null) {
			if (account.getBalance() >= withdraw) {
				dao.withdrawAccount(account, withdraw);
				System.out.println("\nSuccessfully withdrew $" + withdraw + " from " + accountName);
				dao.getAccounts(user);
			} else {
				throw new BankBalanceException("Overdraw rejected - Cannot withdraw more money then you have");
			}
		} else {
			throw new AccountDoesntExistsException("No account exists by that name");
		}
	}

	public static void listTransactions(User user) {
		BankDAOImp dao = new BankDAOImp();
		ArrayList<Account> accounts = user.getAccounts();
		ArrayList<Transaction> trans = new ArrayList<Transaction>();
		for (Account a : accounts) {
			System.out.println(a.getName() + ":");
			trans = dao.getTransaction(a);
			for (Transaction t : trans) {
				System.out.println("$" + t.getAmount() + " " + t.getType() + " " + t.getDate());
			}
			System.out.println(" ");
		}
	}

}
