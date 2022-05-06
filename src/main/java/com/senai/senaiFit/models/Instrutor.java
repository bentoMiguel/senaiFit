package com.senai.senaiFit.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.senai.senaiFit.dtos.InstrutorDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "instutores")
@PrimaryKeyJoinColumn(name="id")
@EqualsAndHashCode(callSuper=false)
public class Instrutor extends Usuario {

	private static final long serialVersionUID = 1L;

	public Instrutor () {
		super();
	}
	
	private Long numeroRegistroProfissional;
}
