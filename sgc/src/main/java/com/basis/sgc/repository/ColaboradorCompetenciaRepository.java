package com.basis.sgc.repository;

import com.basis.sgc.domain.ColaboradorCompetencia;
import com.basis.sgc.domain.ColaboradorCompetenciaChave;
import com.basis.sgc.service.dto.ColaboradorCompetenciaDTO;
import com.basis.sgc.service.dto.ColaboradorListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorCompetenciaRepository extends JpaRepository<ColaboradorCompetencia, ColaboradorCompetenciaChave> {

    @Query("select new " +
            "com.basis.sgc.service.dto.ColaboradorCompetenciaDTO(c.colaborador.id, c.competencia.id, c.nivel)" +
            "from ColaboradorCompetencia c where c.id.id_colaborador = ?1")
    public List<ColaboradorCompetenciaDTO> listar(Integer id);
    
}
