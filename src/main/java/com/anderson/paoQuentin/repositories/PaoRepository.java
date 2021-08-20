package com.anderson.paoQuentin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anderson.paoQuentin.domain.Pao;

@Repository
public interface PaoRepository extends JpaRepository<Pao, Integer>{

}
