package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO {

    @NotNull
    private String label;

    @NotNull
    private Integer value;

    public CategoriaDTO(String label, Integer value) {
        this.label = label;
        this.value = value;
    }
}
