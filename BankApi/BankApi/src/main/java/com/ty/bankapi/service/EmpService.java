package com.ty.bankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.bankapi.dao.EmpDao;
import com.ty.bankapi.entity.Emp;
import com.ty.bankapi.response.ResponseStructure;

@Service
public class EmpService {

	@Autowired
	private EmpDao ed;
	
	public ResponseEntity<ResponseStructure<Emp>> save(Emp e) {
		Emp e1=ed.save(e);
		ResponseStructure<Emp> rs=new ResponseStructure<Emp>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data saved successfully.");
		rs.setData(e1);
		return new ResponseEntity<ResponseStructure<Emp>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Emp>> updateName(int id, String name) {
		Emp e1=ed.updateName(id, name);
		ResponseStructure<Emp> rs=new ResponseStructure<Emp>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data updated successfully.");
		rs.setData(e1);
		return new ResponseEntity<ResponseStructure<Emp>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Emp>> updateEmail(int id, String email) {
		Emp e1=ed.updateEmail(id, email);
		ResponseStructure<Emp> rs=new ResponseStructure<Emp>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data updated successfully.");
		rs.setData(e1);
		return new ResponseEntity<ResponseStructure<Emp>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Emp>> updateMno(int id, long mno) {
		Emp e1=ed.updatePhone(id, mno);
		ResponseStructure<Emp> rs=new ResponseStructure<Emp>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data updated successfully.");
		rs.setData(e1);
		return new ResponseEntity<ResponseStructure<Emp>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Emp>> fetch(int id) {
		Emp e1=ed.fetch(id);
		ResponseStructure<Emp> rs=new ResponseStructure<Emp>();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data fetched successfully.");
		rs.setData(e1);
		return new ResponseEntity<ResponseStructure<Emp>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> delete(int id) {
		ed.delete(id);
		ResponseStructure<String> rs=new ResponseStructure();
		rs.setStatus(HttpStatus.OK.value());
		rs.setMsg("data deleted successfully.");
		rs.setData("data deleted.");
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);
	}
}
