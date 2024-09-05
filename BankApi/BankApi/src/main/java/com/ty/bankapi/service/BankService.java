package com.ty.bankapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.bankapi.dao.BankDao;
import com.ty.bankapi.entity.Bank;
import com.ty.bankapi.response.ResponseStructure;

@Service
public class BankService {

	@Autowired
	private BankDao bd;
	
	public ResponseEntity<ResponseStructure<Bank>> save(Bank b) {
		Bank bank=bd.save(b);
		ResponseStructure<Bank> rs=new ResponseStructure<Bank>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data saved.");
		rs.setData(bank);
		return new ResponseEntity<ResponseStructure<Bank>>(rs, HttpStatus.OK);	
	}
	
	public ResponseEntity<ResponseStructure<Bank>> update(int id, String name) {
		Bank b=bd.update(id, name);
		ResponseStructure<Bank> rs=new ResponseStructure<Bank>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data updated.");
		rs.setData(b);
		return new ResponseEntity<ResponseStructure<Bank>>(rs, HttpStatus.OK);	
	}
	
	public ResponseEntity<ResponseStructure<Bank>> fetch(int id) {
		Bank b=bd.fetch(id);
		ResponseStructure<Bank> rs=new ResponseStructure<Bank>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data fetched.");
		rs.setData(b);
		return new ResponseEntity<ResponseStructure<Bank>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Bank>>> allBanks() {
		List<Bank> banks=bd.fetchALL();
		ResponseStructure<List<Bank>> rs=new ResponseStructure<List<Bank>>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("all data fetched.");
		rs.setData(banks);
		return new ResponseEntity<ResponseStructure<List<Bank>>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> delete(int id) {
		bd.delete(id);
		ResponseStructure<String> rs=new ResponseStructure();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data deleted.");
		rs.setData("data deleted successfully.");
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);
	}
}
