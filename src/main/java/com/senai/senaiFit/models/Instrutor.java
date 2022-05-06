package com.senai.senaiFit.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.senai.senaiFit.dtos.InstrutorDto;

import lombok.Data;

@Data
@Entity
@Table(name = "instutores")
@PrimaryKeyJoinColumn(name="id")
public class Instrutor extends Usuario {
	
	public Instrutor (InstrutorDto dto) {
		super(dto);
		this.numeroRegistroProfissional = dto.getNumeroRegistroProfissional();
	}
	
	public Instrutor () {}
	
	private Long numeroRegistroProfissional;
}
