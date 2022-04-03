package com.basis.sgc.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "turma")
@Getter
@Setter
@SequenceGenerator(name = "seq_turma", sequenceName = "seq_turma", allocationSize = 1)
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_turma")
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate data_inicio;

    @Column(name = "data_termino", nullable = false)
    private LocalDate data_termino;

    @ManyToOne
    @JoinColumn(name = "id_status", nullable = false)
    private Status status;

}
