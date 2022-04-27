package com.basis.sgc.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "turma_competencia_colaborador")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class TurmaColaboradorCompetencia implements Serializable {

    @EmbeddedId
    TurmaColaboradorCompetenciaChave id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idTurma")
    @JoinColumn(name = "idTurma")
    Turma turma;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idColaborador")
    @JoinColumn(name = "idColaborador")
    Colaborador colaborador;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idCompetencia")
    @JoinColumn(name = "id_competencia")
    Competencia competencia;

}
