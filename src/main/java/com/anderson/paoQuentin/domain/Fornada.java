package com.anderson.paoQuentin.domain;

import java.time.LocalDateTime;

public class Fornada {
	
	private Integer id;
	private String nomePao;
	private LocalDateTime tempoPreparo;
	
	private Pao pao;

	public Fornada() {
		super();
	}

	public Fornada(Integer id, String nomePao, LocalDateTime tempoPreparo, Pao pao) {
		super();
		this.id = id;
		this.nomePao = nomePao;
		this.tempoPreparo = tempoPreparo;
		this.pao = pao;
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

	public LocalDateTime getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(LocalDateTime tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public Pao getPao() {
		return pao;
	}

	public void setPao(Pao pao) {
		this.pao = pao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornada other = (Fornada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
