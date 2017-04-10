package com.revature.BankApp;

import junit.framework.*;

import java.sql.SQLException;

import org.junit.Test;

import com.revature.domain.Users;

public class UsersTest extends TestCase{
    public UsersTest( String testName )
    {
        super( testName );
    }

    public void testApp()
    {
        assertTrue( true );
    }
    
    @Test(expected = SQLException.class)
	public final void uniqueNameException () {
    	Users u = new Users("superuser", "p4ssw0rd");
    	u.createNewUser();
	}
    
    @Test(expected = SQLException.class)
    public final void deleteNonUserException () {
    	Users u = new Users("Timmy", "");
    	u.deleteAccount(u.getUSER_NAME());
    }
    
    @Test(expected = SQLException.class)
    public final void missingAccountException() {
    	Users u = new Users("superuser", "p4ssw0rd");
    	u.deleteAccount("checkings");
    }
}
