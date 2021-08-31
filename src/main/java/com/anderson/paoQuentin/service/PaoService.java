package com.anderson.paoQuentin.service;

import java.util.List;
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
	
	@Autowired
	private FornadaService fornadaService;

	public Pao findById(Integer id) {
		Optional<Pao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objetonão encontrado! Id: " + id + ", Tipo: " + Pao.class.getName()));
	}

	public List<Pao> findAll(Integer id_for) {
		fornadaService.findById(id_for);
		return repository.findAllByFornada(id_for);
	}

	public Pao update(Integer id, Pao obj) {
		Pao newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Pao newObj, Pao obj) {
		newObj.setNome(obj.getNome());
		newObj.setTempoPreparo(obj.getTempoPreparo());
	}
	
	

}
