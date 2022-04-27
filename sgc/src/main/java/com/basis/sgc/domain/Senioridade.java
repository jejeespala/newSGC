package com.basis.sgc.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "senioridade")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Senioridade implements Serializable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    Integer id;

    @Column(name = "nome", nullable = false)
    String nome;

}
