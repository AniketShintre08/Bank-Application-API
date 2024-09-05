package com.ty.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.bankapi.entity.DebitCard;
import com.ty.bankapi.entity.Status;
import com.ty.bankapi.response.ResponseStructure;
import com.ty.bankapi.service.DCService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/bankapi/dc")
public class DcControl {

	@Autowired
	private DCService dc;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<DebitCard>> save(@RequestBody DebitCard dc) {
		return this.dc.save(dc);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<ResponseStructure<DebitCard>> fetch(@RequestParam int cno) {
		return dc.fetch(cno);
	}
	
	@PatchMapping("/updatename")
	public ResponseEntity<ResponseStructure<DebitCard>> updateName(@RequestParam int cno, @RequestParam String name) {
		return dc.updateName(cno, name);
	}
	
	@PatchMapping("/updatemno")
	public ResponseEntity<ResponseStructure<DebitCard>> updateMno(@RequestParam int cno, @RequestParam long mno) {
		return dc.updateMno(cno, mno);
	}
	
	@PatchMapping("/updatestatus")
	public ResponseEntity<ResponseStructure<DebitCard>> updateStatus(@RequestParam int cno, @RequestParam Status s) {
		return dc.updateStatus(cno, s);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<String>> delete(@RequestParam int cno) {
		return dc.delete(cno);
	}
}
