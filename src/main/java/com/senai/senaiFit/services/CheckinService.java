package com.senai.senaiFit.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.senai.senaiFit.models.Checkin;
import com.senai.senaiFit.models.Cliente;
import com.senai.senaiFit.models.LimiteEnum;
import com.senai.senaiFit.models.Parceiro;
import com.senai.senaiFit.repositories.CheckinRepository;
import com.senai.senaiFit.repositories.ClienteRepository;
import com.senai.senaiFit.repositories.ParceiroRepository;

@Controller
public class CheckinService {
	
	@Autowired
	private CheckinRepository cr;
	@Autowired
	private ParceiroRepository pr;
	@Autowired
	private ClienteRepository clr;

	public String saveCheckin(long academiaId, long clienteId, int minutos) {
		Checkin checkin = new Checkin();
		checkin.setDataCheckin(LocalDate.now());
		checkin.setMinutosAtividade(minutos);
		Cliente cliente = clr.findById(clienteId).get();
		checkin.setCliente(cliente);
		Parceiro parceiro = pr.findById(academiaId).get();
		checkin.setParceiro(parceiro);
		cr.save(checkin);
		
		return validarMinutosAtividade(minutos, cliente.getIdade(), cliente.getId());
	}
	
	public String validarMinutosAtividade (int minutos, int idade, long clienteId) {
		String msg = "";
		int limiteDia = 0;
		int limiteSem = 0;
		for(LimiteEnum le: LimiteEnum.values()) {
			if (le.idadeMin <= idade && le.idadeMax >= idade) {
				limiteDia = le.limiteDia;
				limiteSem = le.limiteSemana;
			}
		}
		if (minutos > limiteDia) {
			msg = "Cuidado! O excesso de atividade física também pode fazer mal para sua saúde";
		} else {
			LocalDate inicio = LocalDate.now().with(DayOfWeek.SUNDAY).minusDays(6);
			LocalDate fim = LocalDate.now().with(DayOfWeek.SATURDAY);
			List<Checkin> cks = cr.findChickinByCliente(clienteId, inicio, fim);
			
			int totalHoras = 0;
			
			for (Checkin ck : cks) {
				totalHoras += ck.getMinutosAtividade();
			}
			
			if (totalHoras > limiteSem) {
				msg = "Cuidado! O excesso de atividade física também pode fazer mal para sua saúde";				
			}
			
			if (msg.equals("")) {
				msg = "O número de minutos indicado para sua idade é: "+ limiteDia;
			}
		}
		return msg;
	}
	
}
