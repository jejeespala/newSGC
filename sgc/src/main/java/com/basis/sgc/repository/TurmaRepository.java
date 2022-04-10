package com.basis.sgc.repository;

import com.basis.sgc.domain.Turma;
import com.basis.sgc.service.dto.TurmaListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

    @Query("select new " +
            "com.basis.sgc.service.dto.TurmaListDTO(t.id, t.nome, t.descricao, t.data_inicio, t.data_termino, s.nome)" +
            "from Turma t join t.status s"
    )
    public List<TurmaListDTO> buscar();


}
