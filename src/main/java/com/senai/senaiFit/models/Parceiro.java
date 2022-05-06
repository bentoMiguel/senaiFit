package com.senai.senaiFit.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.senai.senaiFit.dtos.ParceiroDto;

import lombok.Data;

@Data
@Entity
@Table(name = "parceiros")
public class Parceiro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String endereco;
	@Column(updatable = false)
	private final LocalDate dataIngresso = LocalDate.now();
	
	public Parceiro() {}
	
	public Parceiro(ParceiroDto dto) {
		nome = dto.getNome();
		endereco = dto.getEndereco();
	}
}
