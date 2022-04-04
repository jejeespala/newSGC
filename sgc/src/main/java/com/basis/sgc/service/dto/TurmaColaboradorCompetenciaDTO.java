package com.basis.sgc.service.dto;

import com.basis.sgc.domain.Nivel;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurmaColaboradorCompetenciaDTO {

    @NotNull
    private Integer id_turma;

    @NotNull
    private Integer id_colaborador;

    @NotNull
    private Integer id_competencia;


}
