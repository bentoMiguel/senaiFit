package com.senai.senaiFit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.senai.senaiFit.dtos.ClienteDto;
import com.senai.senaiFit.services.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService cs;
	
	@GetMapping
	public List<ClienteDto> getAllCliente() {
		return cs.getAllCliente();
	}
	
	@GetMapping("/{id}")
	public ClienteDto getCliente(@PathVariable long id) {
		return cs.getCliente(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDto saveCliente (@RequestBody ClienteDto cliente) {
		return cs.saveCliente(cliente);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteCliente (@PathVariable long id) {
		try {
			cs.deleteCliente(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@PutMapping("/{id}")
	public ClienteDto updateCliente (@PathVariable long id, ClienteDto cliente) {
		return cs.updateCliente(id, cliente);
	}

}
