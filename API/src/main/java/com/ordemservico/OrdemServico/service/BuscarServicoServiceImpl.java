package com.ordemservico.OrdemServico.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ordemservico.OrdemServico.datasource.model.Servico;
//import com.ordemservico.OrdemServico.repository.ResponsavelRepository;
import com.ordemservico.OrdemServico.repository.ServicoRepository;


@Service
public class BuscarServicoServiceImpl {

	@Autowired
	private ServicoRepository servicoRepository;
	
	//@Autowired
	//private ResponsavelRepository responsavelRepository;
	
	public List<Servico> buscar(){
		List<Servico> listServico = servicoRepository.findAll();
		return listServico;
	}
	
	public List<Servico> buscarFiltro(Long id, String status){
		//Optional<Responsavel> responsavel = responsavelRepository.findById(id);
		List<Servico> listServico = servicoRepository.findByResponsavelEStatus(id, status);
		return listServico;
	}
}
