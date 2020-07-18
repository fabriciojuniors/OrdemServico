package com.ordemservico.OrdemServico.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordemservico.OrdemServico.ResponsavelException.ServicoResourceException;
import com.ordemservico.OrdemServico.datasource.model.Servico;
import com.ordemservico.OrdemServico.repository.ServicoRepository;
import com.ordemservico.OrdemServico.resource.model.ServicoResource;

@Service
public class CadastroServicoServiceImpl {

	private static final Logger LOG = Logger.getLogger(CadastroServicoServiceImpl.class);
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private ServicoConversor service;
	
	public void cadastro(ServicoResource servicoResource) {
		try {
			Servico servico = service.conversor(servicoResource);
			servicoRepository.saveAndFlush(servico);
		} catch (ServicoResourceException e) {
			LOG.error("Erro ao salvar servico. \n" + e.getMessage(),e);
		}
	}
}
