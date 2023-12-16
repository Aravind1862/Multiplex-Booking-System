package com.capg.exception;

public class InvalidNameException extends RuntimeException {
	
	String msg;

	public  InvalidNameException(String msg) {
		
		super();
		
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
