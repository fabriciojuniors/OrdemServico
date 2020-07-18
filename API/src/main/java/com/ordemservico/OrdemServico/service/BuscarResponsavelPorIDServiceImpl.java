package com.ordemservico.OrdemServico.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordemservico.OrdemServico.ResponsavelException.ResponsavelNotFound;
import com.ordemservico.OrdemServico.datasource.model.Responsavel;
import com.ordemservico.OrdemServico.repository.ResponsavelRepository;

@Service
public class BuscarResponsavelPorIDServiceImpl {
	
	@Autowired
	private ResponsavelRepository responsavelRepository;
	
	public Responsavel buscarPorId(Long id) throws ResponsavelNotFound {
		Optional<Responsavel> optionalResponsavel = getOptional(id);
		
		Responsavel responsavel = null;
		if(!optionalResponsavel.isPresent()) {
			throw new ResponsavelNotFound("Responsável não encontra. ID: " + id);
		}else {
			responsavel = optionalResponsavel.get();
		}
		return responsavel;
	}

	private Optional<Responsavel> getOptional(Long id) {
		Optional<Responsavel> optionalResponsavel = responsavelRepository.findById(id);
		return optionalResponsavel;
	}
	
	public void DeletePorId(Long id) throws ResponsavelNotFound {
		Optional<Responsavel> optionalResponsavel = getOptional(id);
		
		if(!optionalResponsavel.isPresent()) {
			throw new ResponsavelNotFound("Responsável não encontrado. ID: " + id);
		}else {
			responsavelRepository.delete(optionalResponsavel.get());
		}
	}
	

}
