package com.ty.bankapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.bankapi.dao.BranchDao;
import com.ty.bankapi.entity.Bank;
import com.ty.bankapi.entity.Branch;
import com.ty.bankapi.response.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private BranchDao bd;
	
	public ResponseEntity<ResponseStructure<Branch>> save(Branch b) {
		Branch br=bd.save(b);
		ResponseStructure<Branch> rs=new ResponseStructure<Branch>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data saved.");
		rs.setData(br);
		return new ResponseEntity<ResponseStructure<Branch>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> fetch(int id) {
		Branch b=bd.fetch(id);
		ResponseStructure<Branch> rs=new ResponseStructure<Branch>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data fetched.");
		rs.setData(b);
		return new ResponseEntity<ResponseStructure<Branch>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Branch>>> fetchAll() {
		List<Branch> b=bd.fetchAll();
		ResponseStructure<List<Branch>> rs=new ResponseStructure();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data fetched.");
		rs.setData(b);
		return new ResponseEntity<ResponseStructure<List<Branch>>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Branch>>> fetchByBank(int id) {
		List<Branch> b=bd.fetchByBank(id);
		ResponseStructure<List<Branch>> rs=new ResponseStructure();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data fetched.");
		rs.setData(b);
		return new ResponseEntity<ResponseStructure<List<Branch>>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateName(int id, String name) {
		Branch b=bd.updateName(id, name);
		ResponseStructure<Branch> rs=new ResponseStructure<Branch>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data updated.");
		rs.setData(b);
		return new ResponseEntity<ResponseStructure<Branch>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> delete(int id) {
		bd.delete(id);
		ResponseStructure<String> rs=new ResponseStructure<String>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data deleted.");
		rs.setData("branch deleted.");
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);
	}
}
