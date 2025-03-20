package com.generation.peopleflow.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é Obrigatório!") 
    @Size(min = 5, max = 100, message = "O atributo nome deve conter no mínimo 05 e no máximo 100 caracteres")
    private String nome;
	
	@NotBlank(message = "O atributo Usuario é Obrigatório!") 
	@Email(message = "O atributo Usuario deve ser um email valido!") 
	private String usuario;
	
    @Size(min = 5, max = 5000, message = "O atributo foto nao pode ser maior que 5000 caracteres")
	private String foto;
	 
	@NotBlank(message = "O atributo Senha é Obrigatório!") 
	@Size(min = 8, message = "A Senha deve ter no minimo 8 caracteres")
	private String senha;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("colaborador")
	private List<Colaborador> colaborador;

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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Colaborador> getColaborador() {
		return colaborador;
	}

	public void setColaborador(List<Colaborador> colaborador) {
		this.colaborador = colaborador;
	}

}

