package com.ty.bankapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Account {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private long mno;
	private String ifsc;
	private long accNo;
	private double bal;
	@ManyToOne
//	@JoinColumn(name = "branchId")
	private Branch branch;
	@OneToOne
	private DebitCard dc;
	
}
