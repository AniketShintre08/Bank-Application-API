package com.ty.bankapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Emp {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private long mno;
	private String email;
	@ManyToOne
//	@JsonManagedReference
//	@JoinColumn(name="bid")
	private Bank bank;
	@ManyToOne
//	@JsonManagedReference
	@JoinColumn(name = "branch")
	private Branch branch;
}
