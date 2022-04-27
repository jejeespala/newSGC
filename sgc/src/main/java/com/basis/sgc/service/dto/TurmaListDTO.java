package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class TurmaListDTO implements Serializable {

    @NotNull
    Integer id;

    @NotNull
    String nome;

    @NotNull
    String descricao;

    @NotNull
    LocalDate data_inicio;

    @NotNull
    LocalDate data_termino;

    @NotNull
    String status;

    public TurmaListDTO(Integer id, String nome, String descricao, LocalDate data_inicio, LocalDate data_termino, String status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
        this.status = status;
    }
}
