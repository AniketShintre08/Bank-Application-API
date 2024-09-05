package com.ty.bankapi.exception;

public class DuplicateAcc extends RuntimeException {

	String msg;
	
	public DuplicateAcc(String msg) {
		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
