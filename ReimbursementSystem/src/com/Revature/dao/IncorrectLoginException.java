package com.Revature.dao;

public class IncorrectLoginException extends Exception{
	private static final long serialVersionUID = 1L;
	public IncorrectLoginException(){
	}
	public IncorrectLoginException(String message){
		super();
	}
	public IncorrectLoginException(String message, Throwable cause){
		super(message, cause);
	}	
}
