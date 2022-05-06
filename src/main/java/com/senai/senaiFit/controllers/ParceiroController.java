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

import com.senai.senaiFit.dtos.InstrutorDto;
import com.senai.senaiFit.dtos.ParceiroDto;
import com.senai.senaiFit.services.InstrutorService;
import com.senai.senaiFit.services.ParceiroService;

@RestController
@RequestMapping("parceiro")
public class ParceiroController {
	
	@Autowired
	private ParceiroService ps;
	
	@GetMapping
	public List<ParceiroDto> getAllParceiro() {
		return ps.getAllParceiro();
	}
	
	@GetMapping("/{id}")
	public ParceiroDto getParceiro(@PathVariable long id) {
		return ps.getParceiro(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ParceiroDto saveParceiro (@RequestBody ParceiroDto parceiro) {
		return ps.saveParceiro(parceiro);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteParceiro (@PathVariable long id) {
		try {
			ps.deleteParceiro(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@PutMapping("/{id}")
	public ParceiroDto updateParceiro (@PathVariable long id, ParceiroDto parceiro) {
		return ps.updateParceiro(id, parceiro);
	}

}