package com.senai.senaiFit.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "checkins")
public class Checkin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Parceiro parceiro;	
	@ManyToOne
	private Cliente cliente;
	private LocalDate dataCheckin;
	private int minutosAtividade;
	
}
