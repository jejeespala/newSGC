package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ColaboradorDTO implements Serializable {

    private Integer id;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String sobrenome;

    @NotNull
    @NotEmpty
    private String cpf;

    @NotNull
    private String email;

//    private String foto;

    @NotNull
    @NotEmpty
    private LocalDate data_nasc;

    @NotNull
    @NotEmpty
    private LocalDate data_admi;

    @NotNull
    @NotEmpty
    private Integer id_senioridade;

    @NotNull
    @NotEmpty
    private List<ColaboradorCompetenciaDTO> competencias;

}
