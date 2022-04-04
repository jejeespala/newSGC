package com.basis.sgc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "turma_competencia_colaborador")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TurmaColaboradorCompetencia implements Serializable {

    @EmbeddedId
    private TurmaColaboradorCompetenciaChave id;

    @ManyToOne
    @MapsId("id_turma")
    @JoinColumn(name = "id_turma")
    private Turma turma;

    @ManyToOne
    @MapsId("id_colaborador")
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @ManyToOne
    @MapsId("id_competencia")
    @JoinColumn(name = "id_competencia")
    private Competencia competencia;

}
