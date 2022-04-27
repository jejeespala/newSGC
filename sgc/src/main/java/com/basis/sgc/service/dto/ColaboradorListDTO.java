package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ColaboradorListDTO implements Serializable {

    @NotNull
    Integer id;

    @NotNull
    String nome;

    @NotNull
    String email;

    @NotNull
    String senioridade;

    public ColaboradorListDTO(Integer id, String nome, String email, String senioridade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senioridade = senioridade;
    }
}
