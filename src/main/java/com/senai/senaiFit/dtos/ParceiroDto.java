package com.senai.senaiFit.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ParceiroDto {

	private long id;
	private String nome;
	@NotBlank
	private String endereco;
	private LocalDate dataIngresso;
	
}
