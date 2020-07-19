package com.ordemservico.OrdemServico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordemservico.OrdemServico.ResponsavelException.ResponsavelNotFound;
import com.ordemservico.OrdemServico.ResponsavelException.ServicoNotFound;
import com.ordemservico.OrdemServico.datasource.model.Servico;
import com.ordemservico.OrdemServico.resource.model.ServicoResource;
import com.ordemservico.OrdemServico.service.BuscarServicoPorID;
import com.ordemservico.OrdemServico.service.BuscarServicoServiceImpl;
import com.ordemservico.OrdemServico.service.CadastroServicoServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ServicoController {
	
	@Autowired
	private BuscarServicoServiceImpl serviceBuscar;
	
	@Autowired
	private BuscarServicoPorID serviceBuscarID;
	
	@Autowired
	private CadastroServicoServiceImpl serviceCadastro;
	
	@GetMapping("/servicos")
	public List<Servico> buscar(){
		return serviceBuscar.buscar();
	}
	
	@GetMapping("/servico/{id}")
	public Servico buscarPorID(@PathVariable(name = "id", required = true) Long id) throws ResponsavelNotFound, ServicoNotFound {
		return serviceBuscarID.buscarPorId(id);
	}
	
	@DeleteMapping("/servico/{id}")
	public void DeleteId(@PathVariable(name = "id", required = true)Long id) throws ServicoNotFound {
		serviceBuscarID.DeletePorId(id);
	}
	
	@PostMapping("/servico")
	public void salvar(@RequestBody ServicoResource servico) {
		serviceCadastro.cadastro(servico);
	}
	
	@PutMapping("/servico/{id}")
	public void atualizar(@PathVariable(name = "id", required = true)Long id, @RequestBody ServicoResource servico) {
		serviceCadastro.atualizar(id, servico);
	}
	
	

}
