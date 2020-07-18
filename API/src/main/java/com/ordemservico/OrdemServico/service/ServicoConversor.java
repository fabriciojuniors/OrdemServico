package com.ordemservico.OrdemServico.service;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.ordemservico.OrdemServico.ResponsavelException.ServicoResourceException;
import com.ordemservico.OrdemServico.datasource.model.Servico;
import com.ordemservico.OrdemServico.resource.model.ServicoResource;

@Component
public class ServicoConversor {

	public Servico conversor(ServicoResource servicoResource) throws ServicoResourceException {
		try {
			Servico servico = new Servico();
			
			servico.setCliente(servicoResource.getNome());
			servico.setEndereco(servicoResource.getEndereco());
			servico.setTelefone(servicoResource.getTelefone());
			servico.setEmail(servicoResource.getEmail());
			servico.setProduto(servicoResource.getProduto());
			servico.setTipo_produto(servicoResource.getTipo());
			servico.setMarca_produto(servicoResource.getMarca());
			servico.setData_contratacao(converterData(servicoResource.getContratacao()));
			servico.setData_entrega(converterData(servicoResource.getEntrega()));
			servico.setValor(converterValor(servicoResource.getValor()));
			servico.setResponsavel(servicoResource.getResponsavel());
			servico.setStatus(servicoResource.getStatus());
			return servico;
		} catch (Exception e) {
			throw new ServicoResourceException("Falha ao converter informações do serviço.");
		}
	}
	
	public Long converterLong(String valor) {
		return Long.parseLong(valor);
	}
	public double converterValor(String valor) {
		return Double.parseDouble(valor);
	}
	public LocalDate converterData(String data) {
		return LocalDate.parse(data);
	}
}
