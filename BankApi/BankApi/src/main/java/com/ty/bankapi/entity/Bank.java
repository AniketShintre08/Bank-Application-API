package com.ty.bankapi.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Bank {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	private Address adds;
	@OneToMany(mappedBy = "bank")
	private List<Branch> branches;
	@OneToMany(mappedBy = "bank")
	@JsonBackReference
	private List<Emp> emps;
}
