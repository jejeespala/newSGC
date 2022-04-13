package com.basis.sgc.service.dto;

import com.basis.sgc.domain.Nivel;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ColaboradorCompetenciaDTO implements Serializable {


    private Integer idColaborador;

    @NotNull
    private Integer idCompetencia;

    @NotNull
    private Nivel nivel;

    public ColaboradorCompetenciaDTO(Integer idColaborador, Integer idCompetencia, Nivel nivel) {
        this.idColaborador = idColaborador;
        this.idCompetencia = idCompetencia;
        this.nivel = nivel;
    }
}
