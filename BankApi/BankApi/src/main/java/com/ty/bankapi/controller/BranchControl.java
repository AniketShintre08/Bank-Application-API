package com.ty.bankapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.bankapi.entity.Branch;
import com.ty.bankapi.response.ResponseStructure;
import com.ty.bankapi.service.BranchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/bankapi/branch")
public class BranchControl {

	@Autowired
	private BranchService bs;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Branch>> save(@RequestBody Branch b) {
		return bs.save(b);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<ResponseStructure<Branch>> fetch(@RequestParam int id) {
		return bs.fetch(id);
	}
	
	@GetMapping("/fetchall")
	public ResponseEntity<ResponseStructure<List<Branch>>> fetchAll() {
		return bs.fetchAll();
	}
	
	@GetMapping("/fetchbybank")
	public ResponseEntity<ResponseStructure<List<Branch>>> fetchByBank(@RequestParam int id) {
		return bs.fetchByBank(id);
	}
	
	@PatchMapping("/updatename")
	public ResponseEntity<ResponseStructure<Branch>> update(@RequestParam int id, @RequestParam String name) {
		return bs.updateName(id, name);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<String>> delete(@RequestParam int id) {
		return bs.delete(id);
	}
}
