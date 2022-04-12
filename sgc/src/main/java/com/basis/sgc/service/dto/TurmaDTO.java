package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class TurmaDTO implements Serializable {

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

    @NotNull
    private List<TurmaColaboradorCompetenciaDTO> turmas;

}
