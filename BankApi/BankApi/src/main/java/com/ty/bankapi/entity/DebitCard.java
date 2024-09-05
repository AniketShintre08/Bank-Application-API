package com.ty.bankapi.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

//import ch.qos.logback.core.status.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class DebitCard {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int cno;
	private long mno;
	@CreationTimestamp
	private LocalDateTime ltd;
	@Enumerated(EnumType.STRING)
	private Status status;
	@OneToOne
	private Account  acc;
	
}
