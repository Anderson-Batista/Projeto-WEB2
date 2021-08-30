package com.anderson.paoQuentin.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.paoQuentin.domain.Fornada;
import com.anderson.paoQuentin.domain.Pao;
import com.anderson.paoQuentin.repositories.FornadaRepository;
import com.anderson.paoQuentin.repositories.PaoRepository;

@Service
public class DBservice {
	
	@Autowired
	private FornadaRepository fornadaRepository;	
	
	@Autowired
	private PaoRepository paoRepository;
	
	public void instanciaBaseDados() {
		Fornada f1 = new Fornada(null, "pao frances", "O pao mais pedido", "Em andamento");
		Fornada f2 = new Fornada(null, "pao bolachao", "Um pão muito gostoso", "Pronta");
		Fornada f3 = new Fornada(null, "pao doce com coco", "O pao mais delicioso", "Em andamento");
		
		Pao p1 = new Pao(null, "pao frances", "45 minutos", f1);
		Pao p2 = new Pao(null, "pao Bolachao", "35 minutos", f2);
		Pao p3 = new Pao(null, "pao doce", "50 minutos", f3);
		
		f1.getPaes().addAll(Arrays.asList(p1));
		f2.getPaes().addAll(Arrays.asList(p2));
		f3.getPaes().addAll(Arrays.asList(p3));
		
		this.fornadaRepository.saveAll(Arrays.asList(f1, f2, f3));
		this.paoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
}
