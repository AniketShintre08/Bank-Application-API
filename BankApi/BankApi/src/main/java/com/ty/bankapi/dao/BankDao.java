package com.ty.bankapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bankapi.entity.Bank;
import com.ty.bankapi.exception.NoBankFound;
import com.ty.bankapi.repos.BankRepo;

@Repository
public class BankDao {

	@Autowired
	private BankRepo br;
	
	public Bank save(Bank b) {
		return br.save(b);
	}
	
	public Bank update(int id, String name) {
		Bank b=br.findById(id).orElseThrow(()->new NoBankFound("Bank is not available."));
		b.setName(name);
		br.save(b);
		return b;
	}
	
	public Bank fetch(int id) {
		Bank b=br.findById(id).orElseThrow(()->new NoBankFound("Bank is not available."));
		return b;
	}
	
	public List<Bank> fetchALL() {
		List<Bank> banks=br.findAll();
		if (banks.size()==0) {
			throw new NoBankFound("no banks found.");
		} else {
			return banks;
		}
	}
	
	public void delete(int id) {
		Bank b=br.findById(id).orElseThrow(()->new NoBankFound("Bank is not available."));
		br.delete(b);
	}
}
