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
public class CompetenciaDTO implements Serializable {

    @NotNull
    Integer id;

    @NotNull
    String nome;

    @NotNull
    String descricao;

    @NotNull
    Integer idCategoria;

}
