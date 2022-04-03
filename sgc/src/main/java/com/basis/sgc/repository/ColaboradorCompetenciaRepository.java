package com.basis.sgc.repository;

import com.basis.sgc.domain.ColaboradorCompetencia;
import com.basis.sgc.domain.ColaboradorCompetenciaChave;
import com.basis.sgc.service.dto.ColaboradorCompetenciaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ColaboradorCompetenciaRepository extends JpaRepository<ColaboradorCompetencia, ColaboradorCompetenciaChave> {


}
