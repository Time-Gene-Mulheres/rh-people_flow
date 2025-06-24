package com.generation.peopleflow.controller;

import java.util.List;
import java.util.Optional;

import com.generation.peopleflow.model.ReajusteDTO;
import org.apache.coyote.Response;
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

import com.generation.peopleflow.model.Colaborador;
import com.generation.peopleflow.repository.ColaboradorRepository;
import com.generation.peopleflow.repository.SetorRepository;
import com.generation.peopleflow.service.ColaboradorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/colaboradores")
@CrossOrigin(allowedHeaders = "*", origins = "*")

public class ColaboradorController {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private SetorRepository setorRepository;
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@GetMapping
	public ResponseEntity<List<Colaborador>> getAll(){
		return ResponseEntity.ok(colaboradorRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Colaborador> getById(@PathVariable Long id){
		return colaboradorRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Colaborador>> getByTitulo(@PathVariable String nome){
		return ResponseEntity.ok(colaboradorRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Colaborador> post(@Valid @RequestBody Colaborador colaborador){
		if(setorRepository.existsById(colaborador.getSetor().getId()))
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(colaboradorRepository.save(colaborador));
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Setor não existe!", null);
	}
	
	@PutMapping
	public ResponseEntity<Colaborador> put(@Valid @RequestBody Colaborador colaborador){
		if(colaboradorRepository.existsById(colaborador.getId())) {
			if(setorRepository.existsById(colaborador.getSetor().getId()))
				return ResponseEntity.status(HttpStatus.OK)
						.body(colaboradorRepository.save(colaborador));
			
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O Setor não existe!", null);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PutMapping("/reajuste/{id}")
	public ResponseEntity<Colaborador> reajustarSalario(
			@PathVariable Long id,
			@RequestBody ReajusteDTO reajusteDTO
			) {
		Colaborador colaboradorAtualizado = colaboradorService.reajustar(id, reajusteDTO.getPorcentagem());
		return ResponseEntity.ok(colaboradorAtualizado);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
		
		if(colaborador.isEmpty()) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		colaboradorRepository.deleteById(id);	
	}
}
