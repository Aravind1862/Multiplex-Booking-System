package com.capg.exception;

public class SeatNotAvailable  extends RuntimeException{
	
	
	String msg;

	public SeatNotAvailable(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}