package com.ordemservico.OrdemServico.service;

import org.springframework.stereotype.Component;

import com.ordemservico.OrdemServico.ResponsavelException.ResponsavelResourceException;
import com.ordemservico.OrdemServico.datasource.model.Responsavel;
import com.ordemservico.OrdemServico.resource.model.ResponsavelResource;

@Component
public class ResponsavelConversor {
	
	public Responsavel conversor(ResponsavelResource responsavelResource) throws ResponsavelResourceException {
	
		try {
			Responsavel responsavel = new Responsavel();
			responsavel.setNome(responsavelResource.getNome());
			responsavel.setEmail(responsavelResource.getEmail());
			responsavel.setSexo(responsavelResource.getSexo());
			responsavel.setEndereco(responsavelResource.getEndereco());
			responsavel.setTelefone(responsavelResource.getTelefone());
			
			
			return responsavel;
		} catch (Exception e) {
			throw new ResponsavelResourceException("Falha ao converter as informações.");
		}
	}
	
	
}
