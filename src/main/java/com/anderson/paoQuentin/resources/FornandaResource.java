package com.anderson.paoQuentin.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping
	public ResponseEntity<Fornada> create(@RequestBody Fornada obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<FornadaDto> update(@PathVariable Integer id, @RequestBody FornadaDto objDto){
		Fornada newObj = service.update(id, objDto);
		return ResponseEntity.ok().body(new FornadaDto(newObj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
