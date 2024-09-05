package com.ty.bankapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bankapi.entity.Account;
import com.ty.bankapi.entity.DebitCard;
import com.ty.bankapi.entity.Status;
import com.ty.bankapi.exception.DuplicateAcc;
import com.ty.bankapi.exception.NoAccFound;
import com.ty.bankapi.exception.NoDcFound;
import com.ty.bankapi.repos.AccountRepo;
import com.ty.bankapi.repos.DcRepo;

@Repository
public class DCDao {

	@Autowired
	private DcRepo dr;
	
	@Autowired
	private AccountRepo ar;
	
	public DebitCard save(DebitCard d) {
		DebitCard dc=dr.findByCardNo(d.getCno());
		if (dc!=null) {
			throw new DuplicateAcc("debit card already exists!!!");
		} else {
			if (d.getAcc().getDc()!=null) {
				throw new DuplicateAcc("this account is already having debit card!!!");
			} else {
				Account a=ar.findByAccNo(d.getAcc().getAccNo());
				if (a==null) {
					throw new NoAccFound("no account found!!!");
				} else {
					d.setAcc(a);
					DebitCard debit= dr.save(d);
					
					a.setDc(d);
					a.setMno(d.getAcc().getMno());
					ar.save(a);
						
					return debit;
				}
			}
		}
	}
	
	public DebitCard fetch(int cno) {
		DebitCard dc=dr.findByCardNo(cno);
		if (dc==null) {
			throw new NoDcFound("no data available!!!");
		} else {
			return dc;
		}
	}
	
	public DebitCard updateName(int cno, String name) {
		DebitCard dc=dr.findByCardNo(cno);
		if (dc==null) {
			throw new NoDcFound("no data available!!!");
		} else {
			dc.setName(name);
			return dr.save(dc);
		}
	}
	
	public DebitCard updatePhone(int cno, long mno) {
		DebitCard dc=dr.findByCardNo(cno);
		if (dc==null) {
			throw new NoDcFound("no data available!!!");
		} else {
			dc.setMno(mno);
			return dr.save(dc);
		}
	}
	
	public DebitCard updateStatus(int cno, Status s) {
		DebitCard dc=dr.findByCardNo(cno);
		if (dc==null) {
			throw new NoDcFound("no data available!!!");
		} else {
			dc.setStatus(s);
			return dr.save(dc);
		}
	}
	
	public void delete(int cno) {
		DebitCard dc=dr.findByCardNo(cno);
		if (dc==null) {
			throw new NoDcFound("no data available!!!");
		} else {
			dc.getAcc().setDc(null);
			dr.delete(dc);
		}
	}
}
