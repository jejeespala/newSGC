package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class CompetenciaListDTO implements Serializable {

    @NotNull
    Integer id;

    @NotNull
    String nome;

    @NotNull
    String descricao;

    @NotNull
    String nomeCategoria;

    public CompetenciaListDTO(Integer id, String nome, String descricao, String nomeCategoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.nomeCategoria = nomeCategoria;
    }

}
