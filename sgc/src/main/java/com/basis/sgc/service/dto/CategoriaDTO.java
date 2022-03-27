package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO {

    @NotNull
    private Integer id;

    @NotNull
    private String nome;
}
