package com.martins.dto;

import javax.json.bind.annotation.JsonbProperty;

public class Pokemon {
	@JsonbProperty(value = "base_experience")
	private String experienciaBase;

	public Pokemon() {

	}

	public String getExperienciaBase() {
		return experienciaBase;
	}

	public void setExperienciaBase(String experienciaBase) {
		this.experienciaBase = experienciaBase;
	}

}