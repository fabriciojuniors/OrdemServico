package com.ordemservico.OrdemServico.resource.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ordemservico.OrdemServico.datasource.model.Responsavel;


public class ServicoResource implements Serializable{

	private static final long serialVersionUID = -6385979192610399220L;

	@JsonProperty("cliente")
	private String nome;
	
	@JsonProperty("endereco")
	private String endereco;
	
	@JsonProperty("telefone")
	private String telefone;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("produto")
	private String produto;
	
	@JsonProperty("tipo")
	private String tipo;
	
	@JsonProperty("marca")
	private String marca;
	
	@JsonProperty("contratacao")
	private String contratacao;
	
	@JsonProperty("entrega")
	private String entrega;
	
	@JsonProperty("valor")
	private String valor;
	
	@JsonProperty("responsavel")
	private Responsavel responsavel;
	
	@JsonProperty("status")
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public ServicoResource() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getContratacao() {
		return contratacao;
	}

	public void setContratacao(String contratacao) {
		this.contratacao = contratacao;
	}

	public String getEntrega() {
		return entrega;
	}

	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
