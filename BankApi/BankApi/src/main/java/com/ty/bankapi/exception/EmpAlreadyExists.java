package com.ty.bankapi.exception;

public class EmpAlreadyExists extends RuntimeException {

	String msg;
	
	public EmpAlreadyExists(String msg){
		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
