package com.anderson.paoQuentin.dtos;

import java.io.Serializable;

import com.anderson.paoQuentin.domain.Fornada;

public class FornadaDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nomePao;
	private String descricao;
	private String status;
	
	public FornadaDto() {
		super();
	}

	public FornadaDto(Fornada obj) {
		super();
		this.id = obj.getId();
		this.nomePao = obj.getNomePao();
		this.descricao = obj.getDescricao();
		this.status = obj.getStatus();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomePao() {
		return nomePao;
	}

	public void setNomePao(String nomePao) {
		this.nomePao = nomePao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
