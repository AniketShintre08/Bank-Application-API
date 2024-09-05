package com.ty.bankapi.exception;

public class NoAccFound extends RuntimeException{

	String msg;
	
	public NoAccFound(String msg) {
		this.msg=msg;
	}
		
	
	@Override
	public String getMessage() {
		return msg;
	}
}
