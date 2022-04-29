package com.basis.sgc.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ColaboradorCompetenciaChave implements Serializable {

    @Column(name = "id_colaborador")
    Integer idColaborador;

    @Column(name = "id_competencia")
    Integer idCompetencia;

}
