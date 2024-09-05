package com.ty.bankapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bankapi.entity.Bank;
import com.ty.bankapi.entity.Branch;
import com.ty.bankapi.entity.Emp;
import com.ty.bankapi.exception.EmpAlreadyExists;
import com.ty.bankapi.exception.NoBankFound;
import com.ty.bankapi.exception.NoBranchFound;
import com.ty.bankapi.exception.NoEmpFound;
import com.ty.bankapi.repos.BankRepo;
import com.ty.bankapi.repos.BranchRepo;
import com.ty.bankapi.repos.EmpRepo;

@Repository
public class EmpDao {

	@Autowired
	private EmpRepo er;
	
	@Autowired
	private BankRepo bank;
	
	@Autowired
	private BranchRepo branch;
	
	public Emp save(Emp e) {
		Emp e1=er.findByEmail(e.getEmail());
		if(e1!=null) {
			throw new EmpAlreadyExists("Employee is already regitered.");
		}else {
			Bank b=bank.findById(e.getBank().getId()).orElseThrow(()->new NoBankFound("no bank found!!!"));
			b.getEmps().add(e);
			bank.save(b);
			e.setBank(b);
			
			Branch b2=branch.findById(e.getBranch().getId()).orElseThrow(()->new NoBranchFound("no branch found!!!"));
			b2.getEmps().add(e);
			branch.save(b2);
			e.setBranch(b2);
			
			return er.save(e);
		}
	}
	
	public Emp updateName(int id, String name) {
		Emp e=er.findById(id).orElseThrow(()->new NoEmpFound("Emp record does not found!!!"));
		e.setName(name);
		return er.save(e);
	}
	
	public Emp updateEmail(int id, String email) {
		Emp e=er.findById(id).orElseThrow(()->new NoEmpFound("Emp record does not found!!!"));
		e.setEmail(email);
		return er.save(e);
	}
	
	public Emp updatePhone(int id, long mno) {
		Emp e=er.findById(id).orElseThrow(()->new NoEmpFound("Emp record does not found!!!"));
		e.setMno(mno);
		return er.save(e);
	}
	
	public Emp fetch(int id) {
		Emp e=er.findById(id).orElseThrow(()->new NoEmpFound("Emp record does not found!!!"));
		return e;
	}
	
	public void delete(int id) {
		Emp e=er.findById(id).orElseThrow(()->new NoEmpFound("Emp record does not found!!!"));
		er.delete(e);
	}
}
