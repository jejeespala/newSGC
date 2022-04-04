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
public class TurmaColaboradorCompetenciaChave implements Serializable {

    @Column(name = "id_turma")
    private Integer id_turma;

    @Column(name = "id_colaborador")
    private Integer id_colaborador;

    @Column(name = "id_competencia")
    private Integer id_competencia;

}
