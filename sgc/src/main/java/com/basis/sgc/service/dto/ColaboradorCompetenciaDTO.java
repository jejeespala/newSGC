package com.basis.sgc.service.dto;

import com.basis.sgc.domain.Nivel;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColaboradorCompetenciaDTO {

    @NotNull
    private Integer id_colaborador;

    @NotNull
    private Integer id_competencia;

    @NotNull
    private Nivel nivel;
}
