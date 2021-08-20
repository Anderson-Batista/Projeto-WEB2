package com.anderson.paoQuentin.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornada implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nomePao;
	private LocalDateTime tempoPreparo;
	
	public Fornada() {
		super();	
	}

	public Fornada(Integer id, String nomePao, LocalDateTime tempoPreparo) {
		super();
		this.id = id;
		this.nomePao = nomePao;
		this.tempoPreparo = tempoPreparo;
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
