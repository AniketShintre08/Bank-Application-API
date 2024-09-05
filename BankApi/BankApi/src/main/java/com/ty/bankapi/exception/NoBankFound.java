package com.ty.bankapi.exception;

public class NoBankFound extends RuntimeException{

	String msg;
	
	public NoBankFound(String msg) {
		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
