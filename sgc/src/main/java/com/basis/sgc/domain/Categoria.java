package com.basis.sgc.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@NoArgsConstructor
public class Categoria implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;
}
