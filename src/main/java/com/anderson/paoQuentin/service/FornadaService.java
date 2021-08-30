package com.anderson.paoQuentin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.paoQuentin.domain.Fornada;
import com.anderson.paoQuentin.repositories.FornadaRepository;

@Service
public class FornadaService {

	@Autowired
	private FornadaRepository repository;
	
	public Fornada findById(Integer id) {
		Optional<Fornada> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
