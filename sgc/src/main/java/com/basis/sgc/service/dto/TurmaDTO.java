package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class TurmaDTO implements Serializable {

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
    Integer idStatus;

    @NotNull
    List<TurmaColaboradorCompetenciaDTO> turmas;

}
