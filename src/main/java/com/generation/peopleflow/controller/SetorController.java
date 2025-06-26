package com.generation.peopleflow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.peopleflow.model.Setor;
import com.generation.peopleflow.repository.SetorRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/setores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SetorController {
	
	@Autowired
	private SetorRepository setorRepository;
	
	
	@GetMapping
	public ResponseEntity<List<Setor>> getAll(){
		return ResponseEntity.ok(setorRepository.findAll());
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Setor> getById(@PathVariable Long id){
        return setorRepository.findById(id)
            .map(resposta -> ResponseEntity.ok(resposta))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
	
	@GetMapping("/nome/{nome}")
    public ResponseEntity<List<Setor>> getByTitle(@PathVariable 
    String nome){
        return ResponseEntity.ok(setorRepository
            .findAllByNomeContainingIgnoreCase(nome));
    }
	
	
	@PostMapping
    public ResponseEntity<Setor> post(@Valid @RequestBody Setor setor){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(setorRepository.save(setor));
    }
	
	
	@PutMapping
    public ResponseEntity<Setor> put(@Valid @RequestBody Setor setor){
        return setorRepository.findById(setor.getId())
            .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
            .body(setorRepository.save(setor)))
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Setor> setor = setorRepository.findById(id);
        
        if(setor.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        
        setorRepository.deleteById(id);              
    }	
	

}