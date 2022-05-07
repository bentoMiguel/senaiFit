package com.senai.senaiFit.models;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "clientes")
@PrimaryKeyJoinColumn(name="id")
@EqualsAndHashCode(callSuper=false)
public class Cliente extends Usuario {

	private static final long serialVersionUID = 1L;
		
	public Cliente() {
		super();
	}
	
	public int getIdade() {
		int idade = Period.between(super.getDataNascimento(), LocalDate.now()).getYears();
		return idade;		
	}
}
