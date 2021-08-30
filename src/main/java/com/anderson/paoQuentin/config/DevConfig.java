package com.anderson.paoQuentin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.anderson.paoQuentin.service.DBservice;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBservice dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	public boolean instanciaBaseDeDados() {
		if(strategy.equals("create")) {
			this.dbService.instanciaBaseDados();
		}
		return false;
	}
}
