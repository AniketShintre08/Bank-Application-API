package com.ty.bankapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.bankapi.entity.DebitCard;

public interface DcRepo extends JpaRepository<DebitCard, Integer>{

	@Query("select s from DebitCard s where cno=?1")
	public DebitCard findByCardNo(int cno);

}
