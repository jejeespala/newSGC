package com.basis.sgc.service.dto;

import com.basis.sgc.domain.Nivel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ColaboradorCompetenciaDTO implements Serializable {


    Integer idColaborador;

    @NotNull
    Integer idCompetencia;

    @NotNull
    Nivel nivel;

    public ColaboradorCompetenciaDTO(Integer idColaborador, Integer idCompetencia, Nivel nivel) {
        this.idColaborador = idColaborador;
        this.idCompetencia = idCompetencia;
        this.nivel = nivel;
    }
}
