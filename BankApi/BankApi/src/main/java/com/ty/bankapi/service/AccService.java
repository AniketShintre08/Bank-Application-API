package com.ty.bankapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.bankapi.dao.AccountDao;
import com.ty.bankapi.entity.Account;
import com.ty.bankapi.entity.Branch;
import com.ty.bankapi.response.ResponseStructure;

@Service
public class AccService {

	@Autowired
	private AccountDao ad;
	
	public ResponseEntity<ResponseStructure<Account>> save(Account a) {
		Account acc=ad.save(a);
		ResponseStructure<Account> rs=new ResponseStructure<Account>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data saved successfully.");
		rs.setData(acc);
		return new ResponseEntity<ResponseStructure<Account>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Account>> updateName(int id, String name) {
		Account a=ad.updateName(id, name);
		ResponseStructure<Account> rs=new ResponseStructure<Account>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data updated successfully.");
		rs.setData(a);
		return new ResponseEntity<ResponseStructure<Account>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Account>> updateMno(int id, long mno) {
		Account a=ad.updateMno(id, mno);
		ResponseStructure<Account> rs=new ResponseStructure<Account>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data updated successfully.");
		rs.setData(a);
		return new ResponseEntity<ResponseStructure<Account>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Account>> fetch(long accNo) {
		Account a=ad.fetch(accNo);
		ResponseStructure<Account> rs=new ResponseStructure<Account>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data updated successfully.");
		rs.setData(a);
		return new ResponseEntity<ResponseStructure<Account>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Account>>> fetchAll() {
		List<Account> l=ad.fetchAll();
		ResponseStructure<List<Account>> rs=new ResponseStructure<List<Account>>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data updated successfully.");
		rs.setData(l);
		return new ResponseEntity<ResponseStructure<List<Account>>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> fetchBranch(long accNo) {
		Branch b=ad.fetchBranch(accNo);
		ResponseStructure<Branch> rs=new ResponseStructure<Branch>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data updated successfully.");
		rs.setData(b);
		return new ResponseEntity<ResponseStructure<Branch>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Integer>> count(int id) {
		ResponseStructure<Integer> rs=new ResponseStructure<Integer>();
		rs.setMsg("Data fetched successfully.");
		rs.setStatus(HttpStatus.OK.value());
		rs.setData(ad.count(id));
		return new ResponseEntity<ResponseStructure<Integer>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Account>> addBal(long acc, double bal) {
		Account a=ad.updateBalance(acc, bal);
		ResponseStructure<Account> rs=new ResponseStructure<Account>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data updated successfully.");
		rs.setData(a);
		return new ResponseEntity<ResponseStructure<Account>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Account>> minusBal(long acc, double bal) {
		Account a=ad.reduceBal(acc, bal);
		ResponseStructure<Account> rs=new ResponseStructure<Account>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data updated successfully.");
		rs.setData(a);
		return new ResponseEntity<ResponseStructure<Account>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> transfer(long acc1, long acc2, double bal) {
		ResponseStructure<String> rs=new ResponseStructure();
		if (ad.transfer(acc1, acc2, bal)) {
			rs.setMsg("transfered successfully.");
			rs.setData("transfered successfully.");
			rs.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);
		}else {
			rs.setMsg("transfer failed.");
			rs.setData("no enough balance availabe.");
			rs.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);
		}
	}
}
