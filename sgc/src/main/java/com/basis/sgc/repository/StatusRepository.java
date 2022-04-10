package com.basis.sgc.repository;

import com.basis.sgc.domain.Status;
import com.basis.sgc.service.dto.StatusDropdownDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

    @Query("select new " +
            "com.basis.sgc.service.dto.StatusDropdownDTO(s.nome, s.id)" +
            "from Status s")
    public List<StatusDropdownDTO> listar();

}
