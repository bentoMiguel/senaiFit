package com.senai.senaiFit.models;

public enum LimiteEnum {
	
	ADOLESCENTE(14, 17, 135, 45),
	ADULTO(18, 59, 420, 60),
	IDOSO(60, 999, 90, 30);
	
	public int idadeMin;
	public int idadeMax;
	public int limiteSemana;
	public int limiteDia;
	
	LimiteEnum(int idadeMin, int idadeMax, int limiteSemana, int limiteDia) {
	    this.idadeMin = idadeMin;
	    this.idadeMax = idadeMax;
	    this.limiteSemana = limiteSemana;
	    this.limiteDia = limiteDia;
	}

}
