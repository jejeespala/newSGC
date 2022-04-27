package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class TurmaColaboradorCompetenciaDTO implements Serializable {


    Integer idTurma;

    @NotNull
    Integer idColaborador;

    @NotNull
    Integer idCompetencia;

    public TurmaColaboradorCompetenciaDTO(Integer idTurma, Integer idColaborador, Integer idCompetencia) {
        this.idTurma = idTurma;
        this.idColaborador = idColaborador;
        this.idCompetencia = idCompetencia;
    }
}
