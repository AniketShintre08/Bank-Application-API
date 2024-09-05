package com.ty.bankapi.exception;

public class NoBranchFound extends RuntimeException{

	String msg;
	
	 public NoBranchFound(String msg) {
		this.msg=msg;
	}
		
	
	@Override
	public String getMessage() {
		return msg;
	}

}
