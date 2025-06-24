package com.generation.peopleflow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.generation.peopleflow.model.Colaborador;
import com.generation.peopleflow.repository.ColaboradorRepository;

import jakarta.transaction.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

    public Colaborador reajustar(Long id, double porcentagem) {
        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Colaborador não encontrado!"));

        double fatorReajuste = 1 + (porcentagem / 100.0);
        double novoSalario = colaborador.getSalario() * fatorReajuste;

        colaborador.setSalario(novoSalario);

        return colaboradorRepository.save(colaborador);
    }
}
	

