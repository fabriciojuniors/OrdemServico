package com.ordemservico.OrdemServico.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ordemservico.OrdemServico.datasource.model.Responsavel;
import com.ordemservico.OrdemServico.datasource.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
	List<Servico> findServicosByResponsavel(Optional<Responsavel> responsavel);
	
	@Query(nativeQuery = true, value = "SELECT * FROM servico WHERE servico.responsavel_id=:responsavel AND servico.status=:statusFiltro")
	List<Servico> findByResponsavelEStatus(@Param("responsavel")Long responsavel, @Param("statusFiltro")String status);
	
	@Query(nativeQuery = true, value = "SELECT * FROM servico WHERE servico.responsavel_id=:responsavel")
	List<Servico> findByResponsavel(@Param("responsavel")Long id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM servico WHERE servico.status=:status")
	List<Servico> findByStatus(@Param("status")String status);
}
