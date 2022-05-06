package com.senai.senaiFit.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "checkins")
public class Checkin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private final Cliente cliente;
	@Column(nullable = false)
	private final LocalDate dataCheckin;
	@Column(nullable = false)
	private final int minutosAtividade;
	
}
