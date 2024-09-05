package com.ty.bankapi.response;

import com.ty.bankapi.entity.DebitCard;

import lombok.Data;

@Data
public class ResponseStructure <T>{

	public ResponseStructure(int status, String msg, T data) {
		this.status=status;
		this.msg=msg;
		this.data=data;
	}
	
	public ResponseStructure() {
		
	}
	private int status;
	private String msg;
	private T data;
}
