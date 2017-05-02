package com.revature.exceptions;

public class MyException extends Exception {
	
	public MyException(String message) {
		super(message);
	}
	
	public MyException(String message, Throwable cause) {
		super(message,cause);
	}

}

class SubMyException extends MyException {
	public SubMyException(String message){
		super(message);
	}
}