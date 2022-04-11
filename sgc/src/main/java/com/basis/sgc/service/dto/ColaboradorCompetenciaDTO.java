package com.basis.sgc.service.dto;

import com.basis.sgc.domain.Nivel;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ColaboradorCompetenciaDTO implements Serializable {


    private Integer id_colaborador;

    @NotNull
    private Integer id_competencia;

    @NotNull
    private Nivel nivel;

    public ColaboradorCompetenciaDTO(Integer id_colaborador, Integer id_competencia, Nivel nivel) {
        this.id_colaborador = id_colaborador;
        this.id_competencia = id_competencia;
        this.nivel = nivel;
    }
}
