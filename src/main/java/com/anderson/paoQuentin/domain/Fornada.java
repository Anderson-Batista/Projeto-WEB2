package com.anderson.paoQuentin.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Fornada implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo nome requerido")
	@Length(min = 3, max = 100, message = "O campo nome deve conter entre 3 e 100 caracteres")
	private String nomePao;
	
	@NotEmpty(message = "Campo descrição requerido")
	@Length(min = 3, max = 200, message = "O campo descriçao deve conter entre 3 e 200 caracteres")
	private String descricao;
	
	@NotEmpty(message = "Campo status requerido")
	@Length(min = 3, max = 100, message = "O campo status deve conter entre 3 e 100 caracteres")
	private String status;

	@OneToMany(mappedBy = "fornada")
	private List<Pao> paes = new ArrayList<>();

	public Fornada() {
		super();
	}

	public Fornada(Integer id, String nomePao, String descricao, String status) {
		super();
		this.id = id;
		this.nomePao = nomePao;
		this.descricao = descricao;
		this.status = status;
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

	public List<Pao> getPaes() {
		return paes;
	}

	public void setPaes(List<Pao> paes) {
		this.paes = paes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
