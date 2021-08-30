package com.anderson.paoQuentin.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.paoQuentin.domain.Fornada;
import com.anderson.paoQuentin.dtos.FornadaDto;
import com.anderson.paoQuentin.service.FornadaService;

@RestController
@RequestMapping(value = "/fornadas")
public class FornandaResource {

	@Autowired
	private FornadaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Fornada> findById(@PathVariable Integer id) {
		Fornada obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<FornadaDto>> findAll() {
		List<Fornada> list = service.findAll();
		List<FornadaDto> listDTO = list.stream().map(obj -> new FornadaDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}
