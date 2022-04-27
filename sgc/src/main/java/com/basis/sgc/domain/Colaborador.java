package com.basis.sgc.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "colaborador")
@Getter
@Setter
@NoArgsConstructor
@SequenceGenerator(name = "seq_colaborador", sequenceName = "seq_colaborador", allocationSize = 1)
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Colaborador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_colaborador")
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "nome", nullable = false)
    String nome;

    @Column(name = "sobrenome", nullable = false)
    String sobrenome;

    @Column(name = "cpf", nullable = false, unique = true)
    String cpf;

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Column(name = "foto")
    String foto;

    @Column(name = "data_nasc", nullable = false)
    LocalDate data_nasc;

    @Column (name = "data_admi", nullable = false)
    LocalDate data_admi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_senioridade", referencedColumnName = "id")
    Senioridade senioridade;

    @OneToMany(mappedBy = "colaborador")
    Set<ColaboradorCompetencia> colaboradorCompetencias;

    @OneToMany(mappedBy = "colaborador")
    Set<TurmaColaboradorCompetencia> turmaColaboradorCompetencias;

}
