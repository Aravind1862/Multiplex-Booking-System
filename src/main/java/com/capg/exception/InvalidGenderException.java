package com.capg.exception;

public class InvalidGenderException extends RuntimeException {
	
	String msg;

	public  InvalidGenderException(String msg) {
		
		super();
		
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
