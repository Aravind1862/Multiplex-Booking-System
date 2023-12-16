package com.capg.exception;

public class InvalidPasswordException extends RuntimeException {
		
		String msg;

		public InvalidPasswordException(String msg) {
			
			super();
			
			this.msg = msg;
		}

		public String getMsg() {
			return msg;
		}

}
