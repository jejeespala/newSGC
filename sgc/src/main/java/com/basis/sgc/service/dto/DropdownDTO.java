package com.basis.sgc.service.dto;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class DropdownDTO implements Serializable {

    @NotNull
    @NotEmpty
    String label;

    @NotNull
    @NotEmpty
    Integer value;

    public DropdownDTO(String label, Integer value) {
        this.label = label;
        this.value = value;
    }
}
