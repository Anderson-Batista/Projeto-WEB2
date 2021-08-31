package com.anderson.paoQuentin.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.paoQuentin.domain.Pao;
import com.anderson.paoQuentin.service.PaoService;

@RestController
@RequestMapping(value = "/paes")
public class PaoResource {
	
	@Autowired
	private PaoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pao> finById(@PathVariable Integer id){
		Pao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
