package com.revature.exception;

@SuppressWarnings("serial")
public class NotFoundException extends Exception {
	public NotFoundException(String msg) {
        super(msg);
	}
}
