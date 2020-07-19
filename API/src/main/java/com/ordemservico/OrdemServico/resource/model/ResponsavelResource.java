package com.ordemservico.OrdemServico.resource.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponsavelResource implements Serializable {

	private static final long serialVersionUID = 1L;


	@JsonProperty("nome")
	private String nome;
	

	@JsonProperty("idade")
	private String idade;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("telefone")
	private String telefone;
	
	@JsonProperty("sexo")
	private char sexo;
	
	@JsonProperty("endereco")
	private String endereco;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
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
