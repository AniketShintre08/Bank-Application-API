package com.ty.bankapi.controller;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;

import com.ty.bankapi.entity.Emp;
import com.ty.bankapi.response.ResponseStructure;
import com.ty.bankapi.service.EmpService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/bankapi/emp")
public class EmpControl {

	@Autowired
	private EmpService es;
	
	@PostMapping(path="/save", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<Emp>> save(@RequestBody Emp e) {
		return es.save(e);
	}
	
	@PatchMapping("/updatename")
	public ResponseEntity<ResponseStructure<Emp>> updateName(@RequestParam int id, @RequestParam String name) {
		return es.updateName(id, name);
	}
	
	@PatchMapping("/updateemail")
	public ResponseEntity<ResponseStructure<Emp>> updateEmail(@RequestParam int id, @RequestParam String email) {
		return es.updateEmail(id, email);
	}
	
	@PatchMapping("/updatemno")
	public ResponseEntity<ResponseStructure<Emp>> updateMno(@RequestParam int id, @RequestParam long mno) {
		return es.updateMno(id, mno);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<ResponseStructure<Emp>> fetch(@RequestParam int id) {
		return es.fetch(id);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<String>> delete(@RequestParam int id) {
		return es.delete(id); 
	}
	
}
