package com.generation.peopleflow.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_colaboradores") 
public class Colaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(min = 5, max = 50, message = "O atributo nome deve ter no mínimo 05 e no máximo 50 caracteres!")
	private String nome;
	
	@DecimalMin(value = "0.00", message = "O atributo salário não pode ser negativo!")
	private double salario; 
	
	@NotNull (message = "O atributo data de nascimento não pode ser nulo!")
	@Past (message = "O atributo data de nascimento deve ser anterior a data atual!")
	private LocalDate dataDeNascimento;

    @NotBlank(message = "O atributo cargo é obrigatório!")
    @Size(min = 5, max = 50, message = "O atributo cargo deve ter no mínimo 05 e no máximo 10 caracteres!")
    private String cargo;

    @ManyToOne
    @JsonIgnoreProperties("colaborador")
    private Setor setor;

    @ManyToOne
    @JsonIgnoreProperties("colaborador")
    private Usuario usuario;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
	
	
    
}
