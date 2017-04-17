package com.revature.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.bankExceptions.AccountAlreadyExistsException;
import com.revature.bankExceptions.AccountDoesntExistsException;
import com.revature.bankExceptions.BankBalanceException;
import com.revature.bankExceptions.PasswordException;
import com.revature.bankExceptions.UserDoesntExistException;
import com.revature.bankExceptions.UserNameAlreadyExistsException;
import com.revature.dao.BankDAOImp;
import com.revature.domain.User;
import com.revature.util.AccountUtil;
import com.revature.util.UserUtil;

public class BankTest {

	@Test
	public void duplicateAccountNameOnCreateAccount() {
		boolean thrown = false;
		BankDAOImp dao = new BankDAOImp();
		User user = new User("Mr.Test", "test", 46);
		dao.getAccounts(user);
		try {
			AccountUtil.tryCreate(user, "test");
		} catch (AccountAlreadyExistsException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test
	public void passWordConfirmOnLogin() {
		boolean thrown = false;
		try {
			UserUtil.tryCreate("Mr.Test", "test", "notTest");
		} catch (UserNameAlreadyExistsException e) {
		} catch (PasswordException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test
	public void duplicateUserNameOnCreateUsername() {
		boolean thrown = false;
		try {
			UserUtil.tryCreate("Mr.Test", "test", "test");
		} catch (UserNameAlreadyExistsException e) {
			thrown = true;
		} catch (PasswordException e) {

		}
		assertTrue(thrown);
	}

	@Test
	public void invalidUserNameOnLogin() {
		boolean thrown = false;
		try {
			UserUtil.tryLogin("nonuser", "test");
		} catch (PasswordException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}

	@Test
	public void invalidPasswordOnLogin() {
		boolean thrown = false;
		try {
			UserUtil.tryLogin("Mr.Test", "nonpassword");
		} catch (PasswordException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}

	@Test
	public void noAccountExistsOnDelete() {
		BankDAOImp dao = new BankDAOImp();
		boolean thrown = false;
		try {
			User user = new User("Mr.Test", "test", 46);
			dao.getAccounts(user);
			AccountUtil.tryDelete(user, "nonaccount");
		} catch (AccountDoesntExistsException e) {
			thrown = true;
		} catch (BankBalanceException e) {
		}

		assertTrue(thrown);
	}

	@Test
	public void accountNotEmptyOnDelete() {
		BankDAOImp dao = new BankDAOImp();
		boolean thrown = false;
		try {
			User user = new User("Mr.Test", "test", 46);
			dao.getAccounts(user);
			AccountUtil.tryDelete(user, "test");
		} catch (AccountDoesntExistsException e) {
		} catch (BankBalanceException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}

	@Test
	public void overdraftOnWithdraw() {
		BankDAOImp dao = new BankDAOImp();
		boolean thrown = false;
		try {
			User user = new User("Mr.Test", "test", 46);
			dao.getAccounts(user);
			AccountUtil.withdraw(user, "test", 1000);
		} catch (AccountDoesntExistsException e) {
		} catch (BankBalanceException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}

	@Test
	public void noAccountExistsOnWithdraw() {
		BankDAOImp dao = new BankDAOImp();
		boolean thrown = false;
		try {
			User user = new User("Mr.Test", "test", 46);
			dao.getAccounts(user);
			AccountUtil.withdraw(user, "nonaccount", 1000);
		} catch (AccountDoesntExistsException e) {
			thrown = true;
		} catch (BankBalanceException e) {
		}

		assertTrue(thrown);
	}

	@Test
	public void noUserNameExistsOnDelete() {
		boolean thrown = false;
		try {
			UserUtil.tryDelete("nonuser");
		} catch (UserDoesntExistException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}

	@Test
	public void noUserNameExistsOnUpdate() {
		boolean thrown = false;
		try {
			UserUtil.tryUpdate("nonuser", "user", "user");
		} catch (UserDoesntExistException e) {
			thrown = true;
		} catch (UserNameAlreadyExistsException e) {
		}

		assertTrue(thrown);
	}

	@Test
	public void UserNameAlreadyExistsOnUpdate() {
		boolean thrown = false;
		try {
			UserUtil.tryUpdate("Mr.Test", "SUPER", "user");
		} catch (UserDoesntExistException e) {
		} catch (UserNameAlreadyExistsException e) {
			thrown = true;
		}

		assertTrue(thrown);
	}
}
