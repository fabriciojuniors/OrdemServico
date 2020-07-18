package com.ordemservico.OrdemServico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordemservico.OrdemServico.ResponsavelException.ResponsavelNotFound;
import com.ordemservico.OrdemServico.datasource.model.Responsavel;
import com.ordemservico.OrdemServico.resource.model.ResponsavelResource;
import com.ordemservico.OrdemServico.service.BuscarResponsaveisServiceImpl;
import com.ordemservico.OrdemServico.service.BuscarResponsavelPorIDServiceImpl;
import com.ordemservico.OrdemServico.service.CadastroResponsavelServiceImpl;


@RestController
@RequestMapping(value = "/api")
public class ResponsavelController {

	@Autowired
	private BuscarResponsaveisServiceImpl serviceBuscar;
	
	@Autowired
	private CadastroResponsavelServiceImpl serviceCadastro;
	
	@Autowired
	private BuscarResponsavelPorIDServiceImpl serviceBuscarPorId;
	
	@GetMapping(path = "/responsaveis")
	public List<Responsavel> buscar() {
		return serviceBuscar.buscar();
	}
	
	@GetMapping(path = "/responsavel/{id}")
	public Responsavel buscarPorId(@PathVariable(name = "id", required = true)Long id) throws ResponsavelNotFound {
		return serviceBuscarPorId.buscarPorId(id);
	}
	
	@PostMapping(path = "/responsavel/")
	public void salvar(@RequestBody ResponsavelResource responsavel) {
		serviceCadastro.cadastro(responsavel);
	}
	
	@DeleteMapping(path = "/responsavel/{id}")
	public void deleteId(@PathVariable(name = "id", required = true)Long id) throws ResponsavelNotFound {
		serviceBuscarPorId.DeletePorId(id);
	}
}
