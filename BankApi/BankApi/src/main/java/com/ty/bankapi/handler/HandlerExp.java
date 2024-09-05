package com.ty.bankapi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ty.bankapi.exception.DuplicateAcc;
import com.ty.bankapi.exception.EmpAlreadyExists;
import com.ty.bankapi.exception.NoAccFound;
import com.ty.bankapi.exception.NoBankFound;
import com.ty.bankapi.exception.NoBranchFound;
import com.ty.bankapi.exception.NoEmpFound;
import com.ty.bankapi.response.ResponseStructure;

@ControllerAdvice
public class HandlerExp {

	@ExceptionHandler(NoBankFound.class)
	public ResponseEntity<ResponseStructure<String>> handleNobank(NoBankFound exp) {
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setStatus(HttpStatus.NO_CONTENT.value());
		rs.setData("no bank found.");
		rs.setMsg(exp.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(HttpStatus.OK);
	}
	
	@ExceptionHandler(NoBranchFound.class)
	public ResponseEntity<ResponseStructure<String>> handleNoBranch(NoBranchFound exp) {
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setStatus(HttpStatus.NO_CONTENT.value());
		rs.setData("no branch found.");
		rs.setMsg(exp.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(HttpStatus.OK);
	}
	
	@ExceptionHandler(NoAccFound.class)
	public ResponseEntity<ResponseStructure<String>> handleNoAcc(NoAccFound exp) {
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setStatus(HttpStatus.NO_CONTENT.value());
		rs.setData("no Account found.");
		rs.setMsg(exp.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(HttpStatus.OK);
	}
	
	@ExceptionHandler(NoEmpFound.class)
	public ResponseEntity<ResponseStructure<String>> handleNoEmp(NoEmpFound exp) {
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setStatus(HttpStatus.NO_CONTENT.value());
		rs.setData("no Employee found.");
		rs.setMsg(exp.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(HttpStatus.OK);
	}
	
	@ExceptionHandler(NoBankFound.class)
	public ResponseEntity<ResponseStructure<String>> handlNobank(NoBankFound exp) {
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setStatus(HttpStatus.NO_CONTENT.value());
		rs.setData("no bank found.");
		rs.setMsg(exp.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(HttpStatus.OK);
	}
	
	@ExceptionHandler(DuplicateAcc.class)
	public ResponseEntity<ResponseStructure<String>> handleDuplicate(DuplicateAcc exp) {
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setStatus(HttpStatus.NO_CONTENT.value());
		rs.setData("Duplicate value.");
		rs.setMsg(exp.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(HttpStatus.OK);
	}
	
	@ExceptionHandler(EmpAlreadyExists.class)
	public ResponseEntity<ResponseStructure<String>> handleEmpAlreadyExists(EmpAlreadyExists exp) {
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setStatus(HttpStatus.NO_CONTENT.value());
		rs.setData("no bank found.");
		rs.setMsg(exp.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(HttpStatus.OK);
	}
}
