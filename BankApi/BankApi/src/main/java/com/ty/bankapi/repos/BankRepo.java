package com.ty.bankapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.bankapi.entity.Bank;

public interface BankRepo extends JpaRepository<Bank, Integer> {

}
