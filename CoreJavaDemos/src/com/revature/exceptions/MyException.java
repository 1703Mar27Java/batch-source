package com.revature.exceptions;

public class MyException extends Exception
{
	public MyException()
	{
		
	}
	
	public MyException(String message)
	{
		super(message);
	}
	
	public MyException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4728057702375285641L;

}

class SubMyException extends MyException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8498600705616419039L;

	public SubMyException(String message)
	{
		super(message);
	}
}
