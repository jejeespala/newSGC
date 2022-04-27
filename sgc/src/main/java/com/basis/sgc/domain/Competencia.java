package com.basis.sgc.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "competencia")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "seq_competencia", sequenceName = "seq_competencia", allocationSize = 1)
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Competencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_competencia")
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "nome", nullable = false)
    String nome;

    @Column(name = "descricao", nullable = false)
    String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    Categoria categoria;

    @OneToMany(mappedBy = "competencia")
    Set<ColaboradorCompetencia> colaboradorCompetencias;

    @OneToMany(mappedBy = "competencia")
    Set<TurmaColaboradorCompetencia> turmaColaboradorCompetencias;

}
