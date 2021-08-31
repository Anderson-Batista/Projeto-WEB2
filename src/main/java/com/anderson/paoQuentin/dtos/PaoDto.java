package com.anderson.paoQuentin.dtos;

import java.io.Serializable;

import com.anderson.paoQuentin.domain.Pao;

public class PaoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String tempoPreparo;

	public PaoDto() {
		super();
	}

	public PaoDto(Pao obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.tempoPreparo = obj.getTempoPreparo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(String tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
