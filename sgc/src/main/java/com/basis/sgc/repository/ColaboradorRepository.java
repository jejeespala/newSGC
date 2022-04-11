package com.basis.sgc.repository;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.Competencia;
import com.basis.sgc.service.dto.ColaboradorDropdownDTO;
import com.basis.sgc.service.dto.ColaboradorListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

    @Query("select new " +
            "com.basis.sgc.service.dto.ColaboradorListDTO(c.id, c.nome, c.email, s.nome)" +
            "from Colaborador c join c.senioridade s")
    List<ColaboradorListDTO> listar();

    @Query("select new " +
            "com.basis.sgc.service.dto.ColaboradorDropdownDTO(c.colaborador.nome, c.colaborador.id)" +
            "from ColaboradorCompetencia c where c.nivel = 2 and c.competencia.id = ?1")
    List<ColaboradorDropdownDTO> nivelMaximo(Integer id);

}
