package com.generation.peopleflow.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.peopleflow.model.Colaborador;
import com.generation.peopleflow.repository.ColaboradorRepository;

import jakarta.transaction.Transactional;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

    @Transactional
    public Optional<Colaborador> reajusteSalarial(Long id) {
        Optional<Colaborador> colaboradorOptional = colaboradorRepository.findById(id);

        if (colaboradorOptional.isEmpty()) {
            return Optional.empty();
        }

        // Obtém o colaborador e aplica o reajuste
        Colaborador colaborador = colaboradorOptional.get();
        
        double taxa = 0.10; // 10% de aumento
        double novoSalario = colaborador.getSalario() * (1 + taxa);
        novoSalario = Math.round(novoSalario * 100.0) / 100.0;
        colaborador.setSalario(novoSalario);

        // Salva o novo salário no banco
        colaboradorRepository.save(colaborador);

        return Optional.of(colaborador);
    }
}
	

