package com.anderson.paoQuentin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.paoQuentin.domain.Pao;
import com.anderson.paoQuentin.repositories.PaoRepository;
import com.anderson.paoQuentin.service.exceptions.ObjectNotFoundException;

@Service
public class PaoService {

	@Autowired
	private PaoRepository repository;

	public Pao findById(Integer id) {
		Optional<Pao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objetonão encontrado! Id: " + id + ", Tipo: " + Pao.class.getName()));
	}

}
