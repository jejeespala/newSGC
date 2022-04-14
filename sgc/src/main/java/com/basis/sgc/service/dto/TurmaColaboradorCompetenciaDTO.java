package com.basis.sgc.service.dto;

import com.basis.sgc.domain.Nivel;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TurmaColaboradorCompetenciaDTO implements Serializable {


    private Integer idTurma;

    @NotNull
    private Integer idColaborador;

    @NotNull
    private Integer idCompetencia;

    public TurmaColaboradorCompetenciaDTO(Integer idTurma, Integer idColaborador, Integer idCompetencia) {
        this.idTurma = idTurma;
        this.idColaborador = idColaborador;
        this.idCompetencia = idCompetencia;
    }
}
