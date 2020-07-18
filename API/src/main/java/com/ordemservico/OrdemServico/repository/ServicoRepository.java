package com.ordemservico.OrdemServico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordemservico.OrdemServico.datasource.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
