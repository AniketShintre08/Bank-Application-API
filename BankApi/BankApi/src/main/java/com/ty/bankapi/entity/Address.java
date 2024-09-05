package com.ty.bankapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {
	
	@Id
	@GeneratedValue
	private int id;
	private String city;
	private String streetNo;
	private String state;
	

}
