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
import com.senai.senaiFit.services.InstrutorService;

@RestController
@RequestMapping("instrutor")
public class InstrutorController {
	
	@Autowired
	private InstrutorService is;
	
	@GetMapping
	public List<InstrutorDto> getAllInstrutor() {
		return is.getAllInstrutor();
	}
	
	@GetMapping("/{id}")
	public InstrutorDto getInstrutor(@PathVariable long id) {
		return is.getInstrutor(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public InstrutorDto saveInstrutor (@RequestBody InstrutorDto instrutor) {
		return is.saveInstrutor(instrutor);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteInstrutor (@PathVariable long id) {
		try {
			is.deleteInstrutor(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@PutMapping("/{id}")
	public InstrutorDto updateInstrutor (@PathVariable long id, InstrutorDto instrutor) {
		return is.updateInstrutor(id, instrutor);
	}

}
