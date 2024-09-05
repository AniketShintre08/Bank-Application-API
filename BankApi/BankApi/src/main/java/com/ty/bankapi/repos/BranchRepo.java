package com.ty.bankapi.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.bankapi.entity.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer>{

	
	@Query("select s from Branch s where bank=?1")
	public List<Branch> findByBankId(int id);
}
