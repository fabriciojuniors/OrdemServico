package com.ordemservico.OrdemServico.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordemservico.OrdemServico.ResponsavelException.ResponsavelNotFound;
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
	
	@Autowired
	private BuscarResponsavelPorIDServiceImpl buscarPorId;
	
	public void cadastro(ResponsavelResource responsavelResource) {		
		try {
			Responsavel responsavel = service.conversor(responsavelResource); 
			responsavelRepository.saveAndFlush(responsavel);
		} catch (ResponsavelResourceException e) {
			LOG.error("Erro ao salvar responsável. \n"+e.getMessage(),e);
		}
	}
	
	public void atualizar(ResponsavelResource responsavelResource,Long id) throws ResponsavelNotFound {
		try {
			Responsavel responsavel = buscarPorId.buscarPorId(id);
			responsavel.setNome(responsavelResource.getNome());
			responsavel.setEmail(responsavelResource.getEmail());
			responsavel.setEndereco(responsavelResource.getEndereco());
			responsavel.setSexo(responsavelResource.getSexo());
			responsavel.setTelefone(responsavelResource.getTelefone());
			responsavelRepository.saveAndFlush(responsavel);
		} catch (ResponsavelNotFound e) {
			LOG.error("Erro ao salvar responsável. \n" + e.getMessage(),e);
		}

		
		
	}
}
