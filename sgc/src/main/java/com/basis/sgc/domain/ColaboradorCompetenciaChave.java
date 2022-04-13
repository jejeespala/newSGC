package com.basis.sgc.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class ColaboradorCompetenciaChave implements Serializable {

    @Column(name = "id_colaborador")
    private Integer idColaborador;

    @Column(name = "id_competencia")
    private Integer idCompetencia;

}
