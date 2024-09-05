package com.ty.bankapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.bankapi.entity.Account;
import com.ty.bankapi.entity.Branch;
import com.ty.bankapi.response.ResponseStructure;
import com.ty.bankapi.service.AccService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/bankapi/acc")
public class AccControl {

	@Autowired
	private AccService as;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Account>> save(@RequestBody Account a) {
		return as.save(a);
	}
	
	@PatchMapping("/updatename")
	public ResponseEntity<ResponseStructure<Account>> uodateName(@RequestParam int id, @RequestParam String name) {
		return as.updateName(id, name);
	}
	
	@PatchMapping("/updatemno")
	public ResponseEntity<ResponseStructure<Account>> updateMno(@RequestParam int id, @RequestParam long mno) {
		return as.updateMno(id, mno);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<ResponseStructure<Account>> fetch(@RequestParam long accNo) {
		return as.fetch(accNo);
	}
	
	@GetMapping("/fetchall")
	public ResponseEntity<ResponseStructure<List<Account>>> fetchAll() {
		return as.fetchAll();
	}
	
	@GetMapping("/getchbranch")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranch(@RequestParam long accNo) {
		return as.fetchBranch(accNo);
	}
	
	@GetMapping("/count")
	public ResponseEntity<ResponseStructure<Integer>> count(@RequestParam int id) {
		return as.count(id);
	}
	
	@PatchMapping("/addbal")
	public ResponseEntity<ResponseStructure<Account>> addBal(@RequestParam long accNo, @RequestParam double bal) {
		return as.addBal(accNo, bal);
	}
	
	@PatchMapping("/minusbal")
	public ResponseEntity<ResponseStructure<Account>> minusBal(@RequestParam long accNo, @RequestParam double bal) {
		return as.minusBal(accNo, bal);
	}
	
	@PatchMapping("/transfer")
	public ResponseEntity<ResponseStructure<String>> transfer(@RequestParam long acc1, @RequestParam long acc2, @RequestParam double bal) {
		return as.transfer(acc1, acc2, bal);
	}
}
