package com.generation.peopleflow.controller;

import com.generation.peopleflow.model.Colaborador;
import com.generation.peopleflow.model.Ferias;
import com.generation.peopleflow.repository.ColaboradorRepository;
import com.generation.peopleflow.repository.FeriasRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ferias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FeriasController {

    @Autowired
    private FeriasRepository feriasRepository;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @PostMapping("/agendarferias/{colaboradorId}/")
    public ResponseEntity<Ferias> agendarFerias(@Valid @RequestBody Ferias ferias){
        if(colaboradorRepository.existsById(ferias.getColaborador().getId()))
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(feriasRepository.save(ferias));
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Colaborador não existe!", null);
    }

    @GetMapping
    public ResponseEntity<List<Ferias>> getAll() {
        return ResponseEntity.ok(feriasRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ferias> getById(@PathVariable Long id){
        return feriasRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
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

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Ferias> ferias = feriasRepository.findById(id);

        if(ferias.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        feriasRepository.deleteById(id);
    }


}
