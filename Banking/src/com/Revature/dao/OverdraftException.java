package com.Revature.dao;

public class OverdraftException extends Exception{
	private static final long serialVersionUID = 1L;
	public OverdraftException(){
	}
	public OverdraftException(String message){
		super();
	}
	public OverdraftException(String message, Throwable cause){
		super(message, cause);
	}	
}
