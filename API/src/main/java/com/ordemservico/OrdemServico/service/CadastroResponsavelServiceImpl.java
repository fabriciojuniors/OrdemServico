package com.ordemservico.OrdemServico.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordemservico.OrdemServico.ResponsavelException.ResponsavelResourceException;
import com.ordemservico.OrdemServico.datasource.model.Responsavel;
import com.ordemservico.OrdemServico.repository.ResponsavelRepository;
import com.ordemservico.OrdemServico.resource.model.ResponsavelResource;


@Service
public class CadastroResponsavelServiceImpl {

	private static final Logger LOG = Logger.getLogger(CadastroResponsavelServiceImpl.class);
	
	@Autowired
	private ResponsavelRepository responsavelRepository;
	
	@Autowired
	private ResponsavelConversor service;
	
	public void cadastro(ResponsavelResource responsavelResource) {		
		try {
			Responsavel responsavel = service.conversor(responsavelResource); 
			responsavelRepository.saveAndFlush(responsavel);
		} catch (ResponsavelResourceException e) {
			LOG.error("Erro ao salvar responsável. \n"+e.getMessage(),e);
		}
	}
}
