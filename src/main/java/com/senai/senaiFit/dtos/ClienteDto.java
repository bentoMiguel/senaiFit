package com.senai.senaiFit.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.senai.senaiFit.models.TipoSexoEnum;

import lombok.Data;

@Data
public class ClienteDto {

	private long id;
	@NotBlank
	private String cpf;
	@NotBlank
	private LocalDate dataNascimento;
	@NotBlank
	private String nome;
	private String endereco;
	private TipoSexoEnum sexo;
	private double peso;
	private double altura;
	private double minutosDisponiveis;
	
}
