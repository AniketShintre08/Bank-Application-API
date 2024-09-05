package com.ty.bankapi.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Branch {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private long mno;
	@ManyToOne
	@JsonBackReference
//	@JoinColumn(name = "bid")
	private Bank bank;
	@OneToOne(cascade = CascadeType.ALL)
	private Address adds;
	@OneToMany(mappedBy = "branch")
	private List<Emp> emps;
	@OneToMany(mappedBy = "branch")
	private List<Account> accs;
	

}
