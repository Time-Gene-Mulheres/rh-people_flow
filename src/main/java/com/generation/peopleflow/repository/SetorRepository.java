package com.generation.peopleflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.peopleflow.model.Setor;

public interface SetorRepository extends JpaRepository <Setor, Long>  {
	public List<Setor>findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}
