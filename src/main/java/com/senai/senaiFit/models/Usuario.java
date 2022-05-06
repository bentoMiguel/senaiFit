package com.senai.senaiFit.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.senai.senaiFit.dtos.ClienteDto;
import com.senai.senaiFit.dtos.InstrutorDto;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	@Column(nullable = false)
	private LocalDate dataNascimento;
	@Column(nullable = false)
	private String nome;
	private String endereco;
	@Enumerated(EnumType.STRING)
	private TipoSexoEnum sexo;
	private double peso;
	private double altura;
	
	public Usuario(ClienteDto dto) {
		this.cpf = dto.getCpf();
		this.dataNascimento = dto.getDataNascimento();
		this.nome = dto.getNome();
		this.endereco = dto.getEndereco();
		this.sexo = dto.getSexo();
		this.peso = dto.getPeso();
		this.altura = dto.getAltura();
	}

	public Usuario(InstrutorDto dto) {
		this.cpf = dto.getCpf();
		this.dataNascimento = dto.getDataNascimento();
		this.nome = dto.getNome();
		this.endereco = dto.getEndereco();
		this.sexo = dto.getSexo();
		this.peso = dto.getPeso();
		this.altura = dto.getAltura();
	}
	
	public Usuario() {
	}
	
}
