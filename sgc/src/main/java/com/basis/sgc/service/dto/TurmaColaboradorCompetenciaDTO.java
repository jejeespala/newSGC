package com.basis.sgc.service.dto;

import com.basis.sgc.domain.Nivel;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TurmaColaboradorCompetenciaDTO implements Serializable {

    @NotNull
    private Integer id_turma;

    @NotNull
    private Integer id_colaborador;

    @NotNull
    private Integer id_competencia;

}
