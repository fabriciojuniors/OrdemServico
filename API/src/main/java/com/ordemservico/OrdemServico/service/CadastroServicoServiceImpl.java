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
	
	@Autowired
	private BuscarServicoPorID buscarServicoPorID;
	
	public void cadastro(ServicoResource servicoResource) {
		try {
			Servico servico = service.conversor(servicoResource);
			servicoRepository.saveAndFlush(servico);
		} catch (ServicoResourceException e) {
			LOG.error("Erro ao salvar servico. \n" + e.getMessage(),e);
		}
	}
	
	public void atualizar(Long id, ServicoResource servicoResource) {
		try {
			Servico servico = buscarServicoPorID.buscarPorId(id);
			servico.setCliente(servicoResource.getNome());
			servico.setData_contratacao(service.converterData(servicoResource.getContratacao()));
			servico.setData_entrega((service.converterData(servicoResource.getEntrega())));
			servico.setEmail(servicoResource.getEmail());
			servico.setEndereco(servicoResource.getEndereco());
			servico.setMarca_produto(servicoResource.getMarca());
			servico.setProduto(servicoResource.getProduto());
			servico.setResponsavel(servicoResource.getResponsavel());
			servico.setStatus(servicoResource.getStatus());
			servico.setTelefone(servicoResource.getTelefone());
			servico.setTipo_produto(servico.getTipo_produto());
			servico.setValor(service.converterValor(servicoResource.getValor()));
			servicoRepository.saveAndFlush(servico);
			
		} catch (Exception e) {
			LOG.error("Eero ao salvar serviço. \n"+e.getMessage(),e);
		}
	}
}
