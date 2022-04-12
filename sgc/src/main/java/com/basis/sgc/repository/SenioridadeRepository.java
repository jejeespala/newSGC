package com.basis.sgc.repository;

import com.basis.sgc.domain.Senioridade;
import com.basis.sgc.service.dto.DropdownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SenioridadeRepository extends JpaRepository<Senioridade, Integer> {

    @Query("select new " +
            "com.basis.sgc.service.dto.DropdownDTO(s.nome, s.id)" +
            "from Senioridade s")
    public List<DropdownDTO> listar();

}
