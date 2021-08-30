package com.anderson.paoQuentin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.paoQuentin.domain.Fornada;
import com.anderson.paoQuentin.repositories.FornadaRepository;
import com.anderson.paoQuentin.service.exceptions.ObjectNotFoundException;

@Service
public class FornadaService {

	@Autowired
	private FornadaRepository repository;

	public Fornada findById(Integer id) {
		Optional<Fornada> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + "Tipo: " + Fornada.class.getName()));
	}
	
	public List<Fornada> findAll(){
		return repository.findAll();
	}
	
	public Fornada create(Fornada obj) {
		obj.setId(null);
		return repository.save(obj);
	}
}