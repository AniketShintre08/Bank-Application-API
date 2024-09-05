package com.ty.bankapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bankapi.entity.Account;
import com.ty.bankapi.entity.Branch;
import com.ty.bankapi.exception.DuplicateAcc;
import com.ty.bankapi.exception.NoAccFound;
import com.ty.bankapi.exception.NoBranchFound;
import com.ty.bankapi.repos.AccountRepo;
import com.ty.bankapi.repos.BranchRepo;

@Repository
public class AccountDao {

	@Autowired
	private AccountRepo ar;
	
	@Autowired
	private BranchRepo branch;
	
	public Account save(Account a) {
		Account acc=ar.findByAccNo(a.getAccNo());
		if (acc!=null) {
			throw new DuplicateAcc("acc already exists.");
		} else {
			Branch b=branch.findById(a.getBranch().getId()).orElseThrow(()->new NoBranchFound("no branch found!!!"));
			b.getAccs().add(a);
			branch.save(b);
			
			a.setBranch(b);
			return ar.save(a);
		}
	}
	
	public Account updateName(int id, String name) {
		Account a=ar.findById(id).orElseThrow(()->new NoAccFound("Account not found!!!"));
		a.setName(name);
		return ar.save(a);
	}
	
	public Account updateMno(int id, long mno) {
		Account a=ar.findById(id).orElseThrow(()->new NoAccFound("Account not found!!!"));
		a.setMno(mno);
		return ar.save(a);
	}
	
	public Account fetch(long accNo) {
		Account a=ar.findByAccNo(accNo);
		if (a==null) {
			throw new NoAccFound("Accound not found!!!");
		} else {
			return a;
		}
	}
	
	public List<Account> fetchAll() {
		return ar.findAll();
	}
	
	public Branch fetchBranch(long accNo) {
		Account a=ar.findByAccNo(accNo);
		if (a==null) {
			throw new NoAccFound("Accound not found!!!");
		} else {
			return a.getBranch();
		}
	}
	
	public int count(int id) {
		Branch b=branch.findById(id).orElseThrow(()->new NoBranchFound("no data found!!!"));
		return b.getAccs().size();
	}
	
	public Account updateBalance(long accNo, double bal) {
		Account a=ar.findByAccNo(accNo);
		if (a==null) {
			throw new NoAccFound("Accound not found!!!");
		} else {
			double uBal=a.getBal()+bal;
			a.setBal(uBal);
			return ar.save(a);
		}
	}
	
	public Account reduceBal(long accNo, double bal) {
		Account a=ar.findByAccNo(accNo);
		if (a==null) {
			throw new NoAccFound("Accound not found!!!");
		} else {
			double uBal=a.getBal()-bal;
			a.setBal(uBal);
			return ar.save(a);
		}
	}
	
	public boolean transfer(long acc1, long acc2, double bal) {
		Account a1=ar.findByAccNo(acc1);
		Account a2=ar.findByAccNo(acc2);
		if (a1==null || a2==null) {
			throw new NoAccFound("Accound not found!!!");
		} else {
			if (a1.getBal()<bal) {
				return false;
			}else {
				a1.setBal(a1.getBal()-bal);
				ar.save(a1);
				a2.setBal(a2.getBal()+bal);
				ar.save(a2);
				return true;
			}
			
		}
		
	}
}
