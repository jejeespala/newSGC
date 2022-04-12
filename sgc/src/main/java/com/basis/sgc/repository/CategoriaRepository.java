package com.basis.sgc.repository;

import com.basis.sgc.domain.Categoria;
import com.basis.sgc.service.dto.DropdownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query("select new com.basis.sgc.service.dto.DropdownDTO(c.nome, c.id)" +
    "from Categoria c")
    public List<DropdownDTO> listar();
}
