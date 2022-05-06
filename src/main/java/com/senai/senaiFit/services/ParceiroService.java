package com.senai.senaiFit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.senai.senaiFit.dtos.ParceiroDto;
import com.senai.senaiFit.models.Parceiro;
import com.senai.senaiFit.repositories.ParceiroRepository;

@Controller
public class ParceiroService {

	@Autowired
	private ParceiroRepository pr;
	
	public List<ParceiroDto> getAllParceiro() {
		ArrayList<ParceiroDto> dtos = new ArrayList<>();
		List<Parceiro> parceiros = pr.findAll();
		
		for (Parceiro parceiro : parceiros) {
			ParceiroDto dto = new ParceiroDto();
			BeanUtils.copyProperties(parceiro, dto);
			dtos.add(dto);
		}
		return dtos;
	}
	
	public ParceiroDto getParceiro(long id) {
		Optional<Parceiro> parceiro = pr.findById(id);
		ParceiroDto dto = new ParceiroDto();		
		BeanUtils.copyProperties(parceiro.get(), dto);
		
		return dto;
	}
	
	public ParceiroDto saveParceiro(ParceiroDto dto) {
		Parceiro parceiro = new Parceiro(dto);
		Parceiro newParceiro = pr.save(parceiro);
		dto.setId(newParceiro.getId());
		dto.setDataIngresso(newParceiro.getDataIngresso());
		return dto;
	}
	
	public void deleteParceiro(long id) {
		pr.deleteById(id);
	}
	
	public ParceiroDto updateParceiro(long id, ParceiroDto dto) {
		Parceiro parceiro = new Parceiro(dto);
		parceiro.setId(id);
		pr.save(parceiro);
		
		return this.getParceiro(id);
	}
	
}
