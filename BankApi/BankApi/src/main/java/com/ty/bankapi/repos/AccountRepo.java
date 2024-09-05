package com.ty.bankapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.bankapi.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>{

	@Query("select s from Account s where accNo=?1")
	public Account findByAccNo(long accNo);
}

