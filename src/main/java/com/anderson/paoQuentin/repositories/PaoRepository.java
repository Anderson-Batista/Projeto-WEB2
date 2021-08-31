package com.anderson.paoQuentin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anderson.paoQuentin.domain.Pao;

@Repository
public interface PaoRepository extends JpaRepository<Pao, Integer>{

	@Query("SELECT obj FROM Pao obj WHERE obj.fornada.id = :id_for ORDER BY nome")
	List<Pao> findAllByFornada(@Param(value = "id_for") Integer id_for);

}
