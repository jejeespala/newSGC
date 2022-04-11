package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class ColaboradorListDTO implements Serializable {

    @NotNull
    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    private String email;

    @NotNull
    private String senioridade;

    public ColaboradorListDTO(Integer id, String nome, String email, String senioridade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senioridade = senioridade;
    }
}
