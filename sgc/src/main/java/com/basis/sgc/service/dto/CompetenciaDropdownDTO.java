package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompetenciaDropdownDTO {

    @NotNull
    private String label;

    @NotNull
    private Integer value;

    public CompetenciaDropdownDTO(String label, Integer value) {
        this.label = label;
        this.value = value;
    }

}
