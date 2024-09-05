package com.ty.bankapi.exception;

public class NoDcFound extends RuntimeException{

	String msg;
	
	 public NoDcFound(String msg) {
		this.msg=msg;
	}
		
	
	@Override
	public String getMessage() {
		return msg;
	}
}
