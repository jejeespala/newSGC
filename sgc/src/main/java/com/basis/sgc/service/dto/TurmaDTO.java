package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TurmaDTO {

    @NotNull
    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    private String descricao;

    @NotNull
    private LocalDate data_inicio;

    @NotNull
    private LocalDate data_termino;

    @NotNull
    private Integer id_status;

}
