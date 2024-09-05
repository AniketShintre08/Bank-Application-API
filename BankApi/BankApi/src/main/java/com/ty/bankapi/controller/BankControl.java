package com.ty.bankapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.bankapi.entity.Bank;
import com.ty.bankapi.response.ResponseStructure;
import com.ty.bankapi.service.BankService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/bankapi/bank")
public class BankControl {

	@Autowired
	private BankService bs;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Bank>> save(@RequestBody Bank b) {
		return bs.save(b);
	}
	
	@PatchMapping("/updatename")
	public ResponseEntity<ResponseStructure<Bank>> updateNaame(@RequestParam int id, @RequestParam String name) {
		return bs.update(id, name);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<ResponseStructure<Bank>> fetch(@RequestParam int id) {
		return bs.fetch(id);
	}
	
	@GetMapping("/fetchall")
	public ResponseEntity<ResponseStructure<List<Bank>>> fetchAll() {
		return bs.allBanks();
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<String>> delete(int id) {
		return bs.delete(id);
	}
	
}
