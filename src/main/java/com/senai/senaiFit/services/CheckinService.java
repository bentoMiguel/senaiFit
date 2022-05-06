package com.senai.senaiFit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.senai.senaiFit.repositories.CheckinRepository;

@Controller
public class CheckinService {
	
	@Autowired
	private CheckinRepository cr;
	
	
	
}
