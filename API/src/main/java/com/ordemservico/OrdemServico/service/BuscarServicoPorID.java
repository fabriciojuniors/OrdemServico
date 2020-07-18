package com.ordemservico.OrdemServico.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordemservico.OrdemServico.ResponsavelException.ServicoNotFound;
import com.ordemservico.OrdemServico.datasource.model.Servico;
import com.ordemservico.OrdemServico.repository.ServicoRepository;

@Service
public class BuscarServicoPorID {

	@Autowired
	private ServicoRepository servicoRepository;
	
	public Servico buscarPorId(Long id) throws ServicoNotFound {
		Optional<Servico> optionalServico = getOptional(id);
		Servico servico = null;
		if(!optionalServico.isPresent()) {
			throw new ServicoNotFound("Servico não encontrado. ID: "+id);
		}else {
			servico = optionalServico.get();
		}
		return servico;
		
	}
	
	public void DeletePorId(Long id) throws ServicoNotFound {
		Optional<Servico> optionalServico = getOptional(id);
		
		if(!optionalServico.isPresent()) {
			throw new ServicoNotFound("Serviço não encontrado. ID: " + id);
		}else {
			servicoRepository.delete(optionalServico.get());
		}
		
	}
	
	public Optional<Servico> getOptional(Long id){
		Optional<Servico> optionalServico = servicoRepository.findById(id);
		return optionalServico;
	}
}
