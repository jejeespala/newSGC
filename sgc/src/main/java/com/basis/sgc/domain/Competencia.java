package com.basis.sgc.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Competencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_competencia")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    @OneToMany(mappedBy = "competencia")
    private Set<ColaboradorCompetencia> colaboradorCompetencias;

}
