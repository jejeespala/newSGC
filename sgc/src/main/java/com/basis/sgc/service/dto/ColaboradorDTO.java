package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ColaboradorDTO {

    @NotNull
    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    private String sobrenome;

    @NotNull
    private String cpf;

    @NotNull
    private String email;

//    private String foto;

    @NotNull
    private LocalDate data_nasc;

    @NotNull
    private LocalDate data_admi;

    @NotNull
    private Integer id_senioridade;
}
