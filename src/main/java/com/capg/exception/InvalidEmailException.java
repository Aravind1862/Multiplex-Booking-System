package com.capg.exception;

public class InvalidEmailException extends RuntimeException {
	
	String msg;

	public  InvalidEmailException(String msg) {
		
		super();
		
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
