package com.senai.senaiFit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.senai.senaiFit.dtos.ClienteDto;
import com.senai.senaiFit.models.Cliente;
import com.senai.senaiFit.repositories.ClienteRepository;

@Controller
public class ClienteService {
	
	@Autowired
	private ClienteRepository cr;
	
	
	public List<ClienteDto> getAllCliente() {
		List<Cliente> clientes = cr.findAll();
		ArrayList<ClienteDto> dtos = new ArrayList<>();	
		for (Cliente cliente : clientes) {
			ClienteDto clienteDto = new ClienteDto();
			BeanUtils.copyProperties(cliente, clienteDto);
			dtos.add(clienteDto);
		}
		return dtos;
	}
	
	public ClienteDto getCliente(long id) {
		Optional<Cliente> cliente = cr.findById(id);
		ClienteDto clienteDto = new ClienteDto();
		BeanUtils.copyProperties(cliente.get(), clienteDto);
		return clienteDto;
	}
	
	public ClienteDto saveCliente (ClienteDto dto) {
		Cliente cliente = new Cliente();
    	BeanUtils.copyProperties(dto, cliente);
    	cliente.calcularMinutosDisponiveis(cliente.getDataNascimento());
    	cliente = cr.save(cliente);
    	BeanUtils.copyProperties(cliente, dto);
		return dto;
	}
	
	public void deleteCliente (long id) {
		cr.deleteById(id);
	}

	public ClienteDto updateCliente(long id, ClienteDto dto) {
		Optional<Cliente> opt = cr.findById(id);
		Cliente cliente = opt.get();
		BeanUtils.copyProperties(dto, cliente);
		cliente.calcularMinutosDisponiveis(cliente.getDataNascimento());
		cr.save(cliente);
		BeanUtils.copyProperties(cliente, dto);
		return dto;
	}

}
