package com.basis.sgc.repository;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {
}
