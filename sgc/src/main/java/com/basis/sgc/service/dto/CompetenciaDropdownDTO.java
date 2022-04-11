package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CompetenciaDropdownDTO implements Serializable {

    @NotNull
    private String label;

    @NotNull
    private Integer value;

    public CompetenciaDropdownDTO(String label, Integer value) {
        this.label = label;
        this.value = value;
    }

}
