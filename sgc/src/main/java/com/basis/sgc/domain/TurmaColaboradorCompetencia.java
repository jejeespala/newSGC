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

    @ManyToOne
    @MapsId("idTurma")
    @JoinColumn(name = "idTurma")
    Turma turma;

    @ManyToOne
    @MapsId("idColaborador")
    @JoinColumn(name = "idColaborador")
    Colaborador colaborador;

    @ManyToOne
    @MapsId("idCompetencia")
    @JoinColumn(name = "id_competencia")
    Competencia competencia;

}
