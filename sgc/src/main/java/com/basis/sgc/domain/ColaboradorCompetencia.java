package com.basis.sgc.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "colaborador_competencia")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ColaboradorCompetencia implements Serializable {

    @EmbeddedId
    ColaboradorCompetenciaChave id;

    @ManyToOne
    @MapsId("idColaborador")
    @JoinColumn(name = "idColaborador")
    Colaborador colaborador;

    @ManyToOne
    @MapsId("idCompetencia")
    @JoinColumn(name = "id_competencia")
    Competencia competencia;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "nivel")
    Nivel nivel;

}
