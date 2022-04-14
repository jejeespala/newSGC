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
    @MapsId("idTurma")
    @JoinColumn(name = "idTurma")
    private Turma turma;

    @ManyToOne
    @MapsId("idColaborador")
    @JoinColumn(name = "idColaborador")
    private Colaborador colaborador;

    @ManyToOne
    @MapsId("idCompetencia")
    @JoinColumn(name = "id_competencia")
    private Competencia competencia;

}
