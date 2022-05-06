package com.senai.senaiFit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.senai.senaiFit.dtos.InstrutorDto;
import com.senai.senaiFit.models.Instrutor;
import com.senai.senaiFit.repositories.InstrutorRepository;

@Controller
public class InstrutorService {
	
	@Autowired
	private InstrutorRepository ir;
	
	public List<InstrutorDto> getAllInstrutor() {
		List<Instrutor> instrutores = ir.findAll();
		ArrayList<InstrutorDto> dtos = new ArrayList<>();
		for (Instrutor instrutor : instrutores) {
			InstrutorDto instrutorDto = new InstrutorDto();
			BeanUtils.copyProperties(instrutor, instrutorDto);
			dtos.add(instrutorDto);
		}
		return dtos;
	}
	
	public InstrutorDto getInstrutor(long id) {	
		Optional<Instrutor> instrutor = ir.findById(id);
		InstrutorDto dto = new InstrutorDto();
		BeanUtils.copyProperties(instrutor.get(), dto);
		return dto;
	}
	
	public InstrutorDto saveInstrutor (InstrutorDto dto) {
		Instrutor instrutor = new Instrutor();
		BeanUtils.copyProperties(dto, instrutor);
		instrutor = ir.save(instrutor);
		BeanUtils.copyProperties(instrutor, dto);
		return dto;
	}
	
	public void deleteInstrutor (long id) {
		ir.deleteById(id);
	}

	public InstrutorDto updateInstrutor(long id, InstrutorDto dto) {
		Optional<Instrutor> opt = ir.findById(id);
		Instrutor instrutor = opt.get();
		BeanUtils.copyProperties(dto, instrutor);
		ir.save(instrutor);
		BeanUtils.copyProperties(instrutor, dto);
		return dto;
	}

}
