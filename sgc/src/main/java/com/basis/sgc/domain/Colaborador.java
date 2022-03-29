package com.basis.sgc.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "colaborador")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "seq_colaborador", sequenceName = "seq_colaborador", allocationSize = 1)
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_colaborador")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

//    @Column(name = "foto")
//    private String foto;

    @Column(name = "data_nasc", nullable = false)
    private LocalDate data_nasc;

    @Column (name = "data_admi", nullable = false)
    private LocalDate data_admi;

    @ManyToOne
    @JoinColumn(name = "id_senioridade", referencedColumnName = "id")
    private Senioridade senioridade;

}
