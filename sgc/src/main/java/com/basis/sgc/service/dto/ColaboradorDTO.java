package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ColaboradorDTO implements Serializable {

    Integer id;

    @NotNull
    @NotEmpty
    String nome;

    @NotNull
    @NotEmpty
    String sobrenome;

    @NotNull
    @NotEmpty
    String cpf;

    @NotNull
    String email;

    String foto;

    @NotNull
    @NotEmpty
    LocalDate data_nasc;

    @NotNull
    @NotEmpty
    LocalDate data_admi;

    @NotNull
    @NotEmpty
    Integer idSenioridade;

    @NotNull
    @NotEmpty
    List<ColaboradorCompetenciaDTO> competencias;

}
