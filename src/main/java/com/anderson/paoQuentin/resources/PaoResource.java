package com.anderson.paoQuentin.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.anderson.paoQuentin.domain.Pao;
import com.anderson.paoQuentin.dtos.PaoDto;
import com.anderson.paoQuentin.service.PaoService;

@CrossOrigin("*")
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

	@PutMapping(value = "/{id}")
	public ResponseEntity<Pao> update(@PathVariable Integer id,@Valid @RequestBody Pao obj) {
		Pao newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<Pao> updatePatch(@PathVariable Integer id,@Valid  @RequestBody Pao obj) {
		Pao newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PostMapping
	public ResponseEntity<Pao> create(@RequestParam(value = "fornada", defaultValue = "0") Integer id_for,
			@Valid @RequestBody Pao obj) {
		Pao newObj = service.create(id_for, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/paes/{id}")
				.buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
