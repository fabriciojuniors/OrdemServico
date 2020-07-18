package com.ordemservico.OrdemServico.service;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.ordemservico.OrdemServico.ResponsavelException.ResponsavelResourceException;
import com.ordemservico.OrdemServico.datasource.model.Responsavel;
import com.ordemservico.OrdemServico.resource.model.ResponsavelResource;

@Component
public class ResponsavelConversor {
	
	public Responsavel conversor(ResponsavelResource responsavelResource) throws ResponsavelResourceException {
	
		try {
			Responsavel responsavel = new Responsavel();
			LocalDate idade =  checkIdade(responsavelResource.getIdade());
			
			responsavel.setIdade(idade);
			responsavel.setNome(responsavelResource.getNome());
			return responsavel;
		} catch (Exception e) {
			throw new ResponsavelResourceException("Falha ao converter as informações.");
		}
	}
	
	private LocalDate checkIdade(String idade) {
		return LocalDate.parse(idade);
	}
	
}
