package com.ordemservico.OrdemServico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordemservico.OrdemServico.datasource.model.Responsavel;
import com.ordemservico.OrdemServico.repository.ResponsavelRepository;

@Service
public class BuscarResponsaveisServiceImpl {

	@Autowired
	private ResponsavelRepository responsavelRepository;
	
	public List<Responsavel> buscar(){
		List<Responsavel> listResponsaveis = responsavelRepository.findAll();
		return listResponsaveis;
	}
}
