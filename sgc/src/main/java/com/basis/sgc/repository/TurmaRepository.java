package com.basis.sgc.repository;

import com.basis.sgc.domain.Categoria;
import com.basis.sgc.domain.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {
}
