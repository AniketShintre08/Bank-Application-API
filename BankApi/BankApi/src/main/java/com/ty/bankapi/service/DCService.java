package com.ty.bankapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.bankapi.dao.BranchDao;
import com.ty.bankapi.dao.DCDao;
import com.ty.bankapi.entity.DebitCard;
import com.ty.bankapi.entity.Status;
import com.ty.bankapi.response.ResponseStructure;

@Service
public class DCService {

	@Autowired
	private DCDao dc;
	
	public ResponseEntity<ResponseStructure<DebitCard>> save(DebitCard d) {
		DebitCard dc=this.dc.save(d);
		ResponseStructure<DebitCard> rs=new ResponseStructure<DebitCard>(HttpStatus.OK.value(), "data saved successfully.", dc);
		return new ResponseEntity<ResponseStructure<DebitCard>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<DebitCard>> fetch(int cno) {
		DebitCard d=dc.fetch(cno);
		ResponseStructure<DebitCard> rs=new ResponseStructure<DebitCard>(HttpStatus.OK.value(), "data fetched successfully.", d);
		return new ResponseEntity<ResponseStructure<DebitCard>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<DebitCard>> updateName(int id, String name) {
		DebitCard d=dc.updateName(id, name);
		ResponseStructure<DebitCard> rs=new ResponseStructure<DebitCard>(HttpStatus.OK.value(), "data updated successfully.", d);
		return new ResponseEntity<ResponseStructure<DebitCard>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<DebitCard>> updateMno(int cno, long mno) {
		DebitCard d=dc.updatePhone(cno, mno);
		ResponseStructure<DebitCard> rs=new ResponseStructure<DebitCard>(HttpStatus.OK.value(), "data updated successfully.", d);
		return new ResponseEntity<ResponseStructure<DebitCard>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<DebitCard>> updateStatus(int cno, Status s) {
		DebitCard d=dc.updateStatus(cno, s);
		ResponseStructure<DebitCard> rs=new ResponseStructure<DebitCard>(HttpStatus.OK.value(), "data updated successfully.", d);
		return new ResponseEntity<ResponseStructure<DebitCard>>(rs, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> delete(int cno) {
		dc.delete(cno);
		ResponseStructure<String> rs=new ResponseStructure<String>(HttpStatus.OK.value(), "data deleted successfully.", "data deleted");
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);
	}
}
