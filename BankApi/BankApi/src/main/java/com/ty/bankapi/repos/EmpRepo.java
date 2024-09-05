package com.ty.bankapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.bankapi.entity.Emp;

public interface EmpRepo extends JpaRepository<Emp, Integer>{

	@Query("select s from Emp s where email=?1")
	public Emp findByEmail(String email);
}
