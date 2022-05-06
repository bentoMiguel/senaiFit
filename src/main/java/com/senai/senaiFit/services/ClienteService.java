package com.senai.senaiFit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.senai.senaiFit.dtos.ClienteDto;
import com.senai.senaiFit.models.Cliente;
import com.senai.senaiFit.models.Usuario;
import com.senai.senaiFit.repositories.ClienteRepository;
import com.senai.senaiFit.repositories.UsuarioRepository;

@Controller
public class ClienteService {
	
	@Autowired
	private ClienteRepository cr;
	
	@Autowired
	private UsuarioRepository ur;
	
	public List<ClienteDto> getAllCliente() {
		List<Usuario> usuarios = ur.findAll();
		ArrayList<ClienteDto> dtos = new ArrayList<>();
		
		for (Usuario usuario : usuarios) {
			
			if (cr.findById(usuario.getId()).get().getMinutosDisponiveis() != null) {
				ClienteDto dto = this.getCliente(usuario.getId());
				dtos.add(dto);
			}
		}
		return dtos;
	}
	
	public ClienteDto getCliente(long id) {
		Optional<Usuario> usuario = ur.findById(id);
		Usuario newUsuario = usuario.get();
		
		Optional<Cliente> cliente = cr.findById(id);
		Cliente newCliente = cliente.get();

		ClienteDto dto = new ClienteDto(newUsuario, newCliente);
		return dto;
	}
	
	public ClienteDto saveCliente (ClienteDto dto) {
		Cliente cliente = new Cliente(dto);
		Cliente newCliente = cr.save(cliente);
		dto.setId(newCliente.getId());
		dto.setMinutosDisponiveis(newCliente.getMinutosDisponiveis());
		return dto;
	}
	
	public void deleteCliente (long id) {
		cr.deleteById(id);
	}

	public ClienteDto updateCliente(long id, ClienteDto dto) {
		Cliente cliente = new Cliente(dto);
		cliente.setId(id);
		cr.save(cliente);
		
		return this.getCliente(id);
	}

}
