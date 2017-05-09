package com.revature.exception;

public class LibraryFullException extends Exception {
	
	private static final long serialVersionUID = -2862283805529565731L;
	
	public LibraryFullException(){}
	
	public LibraryFullException(String message){
		super(message);
	}
	
}
