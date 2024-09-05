package com.ty.bankapi.exception;

public class NoEmpFound extends RuntimeException{

	String msg;
	
	 public NoEmpFound(String msg) {
		this.msg=msg;
	}
		
	
	@Override
	public String getMessage() {
		return msg;
	}
}
