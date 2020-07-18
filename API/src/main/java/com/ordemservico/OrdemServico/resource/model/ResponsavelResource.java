package com.ordemservico.OrdemServico.resource.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponsavelResource implements Serializable {

	private static final long serialVersionUID = 1L;


	@JsonProperty("nome")
	private String nome;
	

	@JsonProperty("idade")
	private String idade;
	
	
	public ResponsavelResource(String nome, String idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public ResponsavelResource() {
		
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
