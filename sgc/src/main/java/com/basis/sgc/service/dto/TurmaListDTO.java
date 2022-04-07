package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TurmaListDTO {

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
    private String status;

    public TurmaListDTO(Integer id, String nome, String descricao, LocalDate data_inicio, LocalDate data_termino, String status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
        this.status = status;
    }
}
