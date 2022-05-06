package com.senai.senaiFit.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.senai.senaiFit.models.Cliente;
import com.senai.senaiFit.models.TipoSexoEnum;
import com.senai.senaiFit.models.Usuario;

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
	
	public ClienteDto() {}
	
	public ClienteDto(Usuario u, Cliente c) {
		id = u.getId();
		cpf = u.getCpf();
		dataNascimento = u.getDataNascimento();
		nome = u.getNome();
		endereco = u.getEndereco();
		sexo = u.getSexo();
		peso = u.getPeso();
		altura = u.getAltura();
		minutosDisponiveis = c.getMinutosDisponiveis();
		
	}
}
