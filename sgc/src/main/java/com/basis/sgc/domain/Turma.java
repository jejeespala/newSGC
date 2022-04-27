package com.basis.sgc.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "turma")
@Getter
@Setter
@SequenceGenerator(name = "seq_turma", sequenceName = "seq_turma", allocationSize = 1)
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_turma")
    @Column(name = "id", unique = true, nullable = false)
    Integer id;

    @Column(name = "nome", nullable = false)
    String nome;

    @Column(name = "descricao", nullable = false)
    String descricao;

    @Column(name = "data_inicio", nullable = false)
    LocalDate data_inicio;

    @Column(name = "data_termino", nullable = false)
    LocalDate data_termino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_status", nullable = false)
    Status status;

    @OneToMany(mappedBy = "turma")
    Set<TurmaColaboradorCompetencia> turmaColaboradorCompetencias;


}
