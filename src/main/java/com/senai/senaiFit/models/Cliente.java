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
	
	private Integer minutosDisponiveis;
	private Integer minutosUtilizados;
	
	public Cliente() {
		super();
	}
	
	public void calcularMinutosDisponiveis(LocalDate dataNascimento) {
		int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
		
		if (idade < 14)
			return;
		else if (idade >= 14 && idade <= 17)
			this.minutosDisponiveis = 135;
		else if (idade >= 18 && idade <= 59)
			this.minutosDisponiveis = 420;
		else if (idade >= 60)
			this.minutosDisponiveis = 90;
			
	}
}
