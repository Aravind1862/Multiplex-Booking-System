package com.capg.exception;

public class UsersAlreadyExistsException extends RuntimeException {
	
	String msg;

	public  UsersAlreadyExistsException(String msg) {
		
		super();
		
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
