package com.capg.exception;

public class PasswordMismatchException extends RuntimeException {

	String msg;

	public PasswordMismatchException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
