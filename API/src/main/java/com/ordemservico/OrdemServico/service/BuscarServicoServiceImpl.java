package com.ordemservico.OrdemServico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordemservico.OrdemServico.datasource.model.Servico;
import com.ordemservico.OrdemServico.repository.ServicoRepository;

@Service
public class BuscarServicoServiceImpl {

	@Autowired
	private ServicoRepository servicoRepository;
	
	public List<Servico> buscar(){
		List<Servico> listServico = servicoRepository.findAll();
		return listServico;
	}
}
