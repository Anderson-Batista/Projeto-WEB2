package com.anderson.paoQuentin.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo nome requerido")
	@Length(min = 3, max = 100, message = "O campo nome deve conter entre 3 e 100 caracteres")
	private String nome;
	
	@NotEmpty(message = "Campo tempoPreparo requerido")
	@Length(min = 3, max = 100, message = "O campo tempoPreparo deve conter entre 3 e 50 caracteres")
	private String tempoPreparo;

	@JsonIgnore
	@ManyToOne()
	@JoinColumn()
	private Fornada fornada;

	public Pao() {
		super();
	}

	public Pao(Integer id, String nome, String tempoPreparo, Fornada fornada) {
		super();
		this.id = id;
		this.nome = nome;
		this.tempoPreparo = tempoPreparo;
		this.fornada = fornada;
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

	public Fornada getFornada() {
		return fornada;
	}

	public void setFornada(Fornada fornada) {
		this.fornada = fornada;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Pao other = (Pao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
