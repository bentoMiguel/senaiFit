package com.senai.senaiFit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.senaiFit.models.Checkin;
import com.senai.senaiFit.services.CheckinService;

@RestController
@RequestMapping("/checkin")
public class CheckinController {

	@Autowired
	private CheckinService cs;
	
	@PostMapping("/{academiaId}/{clienteId}/{minutos}")
	public String fazerCheckin (@PathVariable long academiaId, @PathVariable long clienteId,
			@PathVariable int minutos) {
		return cs.saveCheckin(academiaId, clienteId, minutos);
	}
	
	@GetMapping("/academia/{id}")
	public List<Checkin> getAcademiaCheckins(@PathVariable long id) {
		return cs.getParceiroCheckins(id);
	}
	
	@GetMapping("/cliente/{id}")
	public List<Checkin> getClienteCheckins(@PathVariable long id) {
		return cs.getClienteCheckinsMes(id);
	}
	
}
