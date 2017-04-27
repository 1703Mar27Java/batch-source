package com.revature.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.domain.User;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.EmailException;
import com.revature.exceptions.PasswordException;
import com.revature.exceptions.UsernameException;
import com.revature.util.UserUtil;

public class ERSTest {

	@Test
	public void duplicateUsernameOnCreateUser() {
		boolean thrown = false;
		User user = new User("TEST", null, null, null, null, null);
		try {
			UserUtil.tryCreate(user);
		} catch (UsernameException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	
	@Test
	public void duplicateEmailOnUpdateUser() {
		boolean thrown = false;
		User user = new User("TEST", null, null, null, null, null);
		try {
			UserUtil.tryUpdateUserInformation(user, "test", "tester", "EMAIL");
		} catch (EmailException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	
	@Test
	public void passwordsDoNotMatchOnUpdateUserPassword() {
		boolean thrown = false;
		User user = new User("TEST", null, null, null, null, null);
		try {
			UserUtil.tryUpdatePassword(user, "test", "nottest");
		} catch (PasswordException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	@Test
	public void userDoesntExistOnLogin() {
		boolean thrown = false;
		
		try {
			UserUtil.tryLogin("NOTTEST", "TEST");
		} catch (AuthenticationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
	
	@Test
	public void incorrectPasswordOnLogin() {
		boolean thrown = false;	
		try {
			UserUtil.tryLogin("TEST", "NOTTEST");
		} catch (AuthenticationException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	
}