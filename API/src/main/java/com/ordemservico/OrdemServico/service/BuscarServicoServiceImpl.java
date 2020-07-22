package com.ordemservico.OrdemServico.service;


import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ordemservico.OrdemServico.datasource.model.Servico;
//import com.ordemservico.OrdemServico.repository.ResponsavelRepository;
import com.ordemservico.OrdemServico.repository.ServicoRepository;


@Service
public class BuscarServicoServiceImpl {

	@Autowired
	private ServicoRepository servicoRepository;
	private static final Logger LOG = Logger.getLogger(BuscarServicoServiceImpl.class);
	
	//@Autowired
	//private ResponsavelRepository responsavelRepository;
	
	public List<Servico> buscar(){
		List<Servico> listServico = servicoRepository.findAll();
		return listServico;
	}
	
	public List<Servico> buscarFiltro(Long id, String status){
		LOG.info("Variavel status:"+status + "\n Variavel ID: " + id);
		List<Servico> listServico = servicoRepository.findByResponsavelEStatus(id, status);
		return listServico;
		
	}
	public List<Servico> buscarFiltroResponsavel(Long id){
		LOG.info("Variavel ID: " + id);
		List<Servico> listServico = servicoRepository.findByResponsavel(id);
		return listServico;
		
	}
	public List<Servico> buscarFiltroStatus(String status){
		LOG.info("Variavel Status: " + status);
		List<Servico> listServico = servicoRepository.findByStatus(status);
		return listServico;
		
	}
}
