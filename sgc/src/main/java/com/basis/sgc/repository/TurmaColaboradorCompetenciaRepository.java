package com.basis.sgc.repository;

import com.basis.sgc.domain.ColaboradorCompetencia;
import com.basis.sgc.domain.ColaboradorCompetenciaChave;
import com.basis.sgc.domain.TurmaColaboradorCompetencia;
import com.basis.sgc.domain.TurmaColaboradorCompetenciaChave;
import com.basis.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaColaboradorCompetenciaRepository extends JpaRepository<TurmaColaboradorCompetencia, TurmaColaboradorCompetenciaChave> {

    @Query("select new com.basis.sgc.service.dto.TurmaColaboradorCompetenciaDTO(t.turma.id, t.id.idColaborador, t.id.idCompetencia)" +
    "from TurmaColaboradorCompetencia t where t.colaborador.id = ?1")
    List<TurmaColaboradorCompetenciaDTO> buscar(Integer id);

}
