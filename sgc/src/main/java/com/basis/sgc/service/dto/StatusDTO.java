package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StatusDTO implements Serializable {

    @NotNull
    private Integer id;

    @NotNull
    private String nome;
}
