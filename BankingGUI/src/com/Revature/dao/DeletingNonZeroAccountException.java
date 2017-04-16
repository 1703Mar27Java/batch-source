package com.Revature.dao;

public class DeletingNonZeroAccountException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public DeletingNonZeroAccountException(){
	}
	public DeletingNonZeroAccountException(String message){
		super();
	}
	public DeletingNonZeroAccountException(String message, Throwable cause){
		super(message, cause);
	}	

}
