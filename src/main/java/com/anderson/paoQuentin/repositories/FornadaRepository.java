package com.anderson.paoQuentin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anderson.paoQuentin.domain.Fornada;

@Repository
public interface FornadaRepository extends JpaRepository<Fornada, Integer>{
	
}
