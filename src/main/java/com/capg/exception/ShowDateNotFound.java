package com.capg.exception;

public class ShowDateNotFound extends RuntimeException{
	String msg;

	public ShowDateNotFound(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

}
