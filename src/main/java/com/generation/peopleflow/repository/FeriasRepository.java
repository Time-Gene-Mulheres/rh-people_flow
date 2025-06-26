package com.generation.peopleflow.repository;

import com.generation.peopleflow.model.Ferias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeriasRepository extends JpaRepository<Ferias, Long> {
    List<Ferias> findAllByColaboradorId(Long colaboradorId);
}
