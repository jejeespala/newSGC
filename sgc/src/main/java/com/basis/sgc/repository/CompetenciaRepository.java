package com.basis.sgc.repository;

import com.basis.sgc.domain.Categoria;
import com.basis.sgc.domain.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetenciaRepository extends JpaRepository<Competencia, Integer> {
}
