package com.Revature.dao;

public class UsernameExistsException extends Exception{
	private static final long serialVersionUID = 1L;
	public  UsernameExistsException(){
	}
	public  UsernameExistsException(String message){
		super();
	}
	public  UsernameExistsException(String message, Throwable cause){
		super(message, cause);
	}	
}
