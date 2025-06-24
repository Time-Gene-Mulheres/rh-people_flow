package com.generation.peopleflow.controller;

import com.generation.peopleflow.model.Ferias;
import com.generation.peopleflow.repository.ColaboradorRepository;
import com.generation.peopleflow.repository.FeriasRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ferias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FeriasController {

    @Autowired
    private FeriasRepository feriasRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public ResponseEntity<Ferias> agendarFerias(@PathVariable Long colaboradorId, @RequestBody Ferias ferias) {
        return colaboradorRepository.findById(colaboradorId).map(colaborador -> {
            ferias.setColaborador(colaborador);
            ferias.setStatus("AGENDADA");
            return ResponseEntity.status(HttpStatus.CREATED).body(feriasRepository.save(ferias));
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Ferias>> getAll() {
        return ResponseEntity.ok(feriasRepository.findAll());
    }

    @GetMapping("/colaborador/{colaboradorId}")
    public ResponseEntity<List<Ferias>> getByColaborador(@PathVariable Long colaboradorId) {
        return ResponseEntity.ok(feriasRepository.findAllByColaboradorId(colaboradorId));
    }

    @PutMapping("/atualizar_status/{feriasId}")
    public ResponseEntity<Ferias> atualizarStatus(@PathVariable Long feriasId, @RequestBody Ferias feriasDetails) {
        return feriasRepository.findById(feriasId).map(ferias -> {
            ferias.setStatus(feriasDetails.getStatus());
            return ResponseEntity.ok(feriasRepository.save(ferias));
        }).orElse(ResponseEntity.notFound().build());
    }


}
