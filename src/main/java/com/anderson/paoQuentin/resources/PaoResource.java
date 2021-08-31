package com.anderson.paoQuentin.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.paoQuentin.domain.Pao;
import com.anderson.paoQuentin.dtos.PaoDto;
import com.anderson.paoQuentin.service.PaoService;

@RestController
@RequestMapping(value = "/paes")
public class PaoResource {

	@Autowired
	private PaoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pao> finById(@PathVariable Integer id) {
		Pao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<PaoDto>> findAll(@RequestParam(value = "fornada", defaultValue = "0") Integer id_for) {
		List<Pao> list = service.findAll(id_for);
		List<PaoDto> listDTO = list.stream().map(obj -> new PaoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
