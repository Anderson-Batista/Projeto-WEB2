package com.anderson.paoQuentin;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anderson.paoQuentin.domain.Fornada;
import com.anderson.paoQuentin.domain.Pao;
import com.anderson.paoQuentin.repositories.FornadaRepository;
import com.anderson.paoQuentin.repositories.PaoRepository;

@SpringBootApplication
public class PaoQuentinApplication implements CommandLineRunner{
	
	@Autowired
	private FornadaRepository fornadaRepository;	
	
	@Autowired
	private PaoRepository paoRepository;

	public static void main(String[] args) {
		SpringApplication.run(PaoQuentinApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Fornada f1 = new Fornada(null, "pao frances", "O pao mais pedido", "Em andamento");
		
		Pao p1 = new Pao(null, "pao frances", "45 minutos", f1);
		
		f1.getPaes().addAll(Arrays.asList(p1));
		
		this.fornadaRepository.saveAll(Arrays.asList(f1));
		this.paoRepository.saveAll(Arrays.asList(p1));
	}

	
}
