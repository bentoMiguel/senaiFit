package com.senai.senaiFit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.senai.senaiFit.dtos.InstrutorDto;
import com.senai.senaiFit.models.Instrutor;
import com.senai.senaiFit.models.Usuario;
import com.senai.senaiFit.repositories.InstrutorRepository;
import com.senai.senaiFit.repositories.UsuarioRepository;

@Controller
public class InstrutorService {
	
	@Autowired
	private InstrutorRepository ir;
	
	@Autowired
	private UsuarioRepository ur;
	
	public List<InstrutorDto> getAllInstrutor() {
		List<Usuario> usuarios = ur.findAll();
		ArrayList<InstrutorDto> dtos = new ArrayList<>();
		
		for (Usuario usuario : usuarios) {
			
			if (ir.findById(usuario.getId()).get().getNumeroRegistroProfissional() != null) {
				InstrutorDto dto = this.getInstrutor(usuario.getId());
				dtos.add(dto);
			}
		}
		return dtos;
	}
	
	public InstrutorDto getInstrutor(long id) {
		Optional<Usuario> usuario = ur.findById(id);
		Usuario newUsuario = usuario.get();
		
		Optional<Instrutor> instrutor = ir.findById(id);
		Instrutor newInstrutor = instrutor.get();

		InstrutorDto dto = new InstrutorDto(newUsuario, newInstrutor);
		return dto;
	}
	
	public InstrutorDto saveInstrutor (InstrutorDto dto) {
		Instrutor instrutor = new Instrutor(dto);
		Instrutor newInstrutor = ir.save(instrutor);
		dto.setId(newInstrutor.getId());
		return dto;
	}
	
	public void deleteInstrutor (long id) {
		ir.deleteById(id);
	}

	public InstrutorDto updateInstrutor(long id, InstrutorDto dto) {
		Instrutor instrutor = new Instrutor(dto);
		instrutor.setId(id);
		ir.save(instrutor);
		
		return this.getInstrutor(id);
	}

}
