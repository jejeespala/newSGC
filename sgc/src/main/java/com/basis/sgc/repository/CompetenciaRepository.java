package com.basis.sgc.repository;

import com.basis.sgc.domain.Competencia;
import com.basis.sgc.service.dto.CompetenciaListDTO;
import com.basis.sgc.service.dto.DropdownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Integer> {

    @Query("select new " +
            "com.basis.sgc.service.dto.CompetenciaListDTO(c.id, c.nome, c.descricao, ca.nome) " +
            "from Competencia c join c.categoria ca")
    public List<CompetenciaListDTO> listar();

    @Query("select new com.basis.sgc.service.dto.DropdownDTO(c.nome, c.id) from Competencia c")
    public List<DropdownDTO> listarDrop();
}
