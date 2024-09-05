package com.ty.bankapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bankapi.entity.Bank;
import com.ty.bankapi.entity.Branch;
import com.ty.bankapi.exception.NoBankFound;
import com.ty.bankapi.exception.NoBranchFound;
import com.ty.bankapi.repos.BankRepo;
import com.ty.bankapi.repos.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	private BranchRepo br;
	
	@Autowired
	private BankRepo bRepo;
	
	public Branch save(Branch b) {
		Bank bank=bRepo.findById(b.getBank().getId()).orElseThrow(()->new NoBankFound("no bank details found!!!"));
		bank.getBranches().add(b);
		bRepo.save(bank);
		b.setBank(bank);
		return br.save(b);
	}
	
	public Branch fetch(int id) {
		Branch b=br.findById(id).orElseThrow(()->new NoBranchFound("no data found!!!"));
		return b;
	}
	
	public List<Branch> fetchAll() {
		List<Branch> b=br.findAll();
		if(b.size()==0) {
			throw new NoBranchFound("no records found!!!");
		}else {
			return b;
		}
	}
	
	public List<Branch> fetchByBank(int id) {
		Bank b=bRepo.findById(id).orElseThrow(()->new NoBankFound("no bank record found!!!"));
		System.out.println("hello");
		List<Branch> bList=br.findByBankId(id);
		if(bList.size()==0) {
			throw new NoBranchFound("no records found!!!");
		}else {
			return bList;
		}
	}
	
	public Branch updateName(int id, String name) {
		Branch b=br.findById(id).orElseThrow(()->new NoBranchFound("no data is available!!!"));
		b.setName(name);
		return br.save(b);
	}
	
	public void delete(int id) {
		Branch b=br.findById(id).orElseThrow(()->new NoBranchFound("no data is available!!!"));
		br.delete(b);
	}
}
