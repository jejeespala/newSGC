package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.Turma;
import com.basis.sgc.service.dto.TurmaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurmaMapper extends EntityMapper<TurmaDTO, Turma> {

    @Mapping(target = "status.id", source = "idStatus")
    Turma toEntity(TurmaDTO turmaDTO);


    @Mapping(target = "idStatus", source = "status.id")
    TurmaDTO toDto (Turma turma);

    @Mapping(target = "status.id", source = "idStatus")
    List<Turma> toEntity (List<TurmaDTO> turmaDTOS);

    @Mapping(target = "idStatus", source = "status.id")
    List<TurmaDTO> toDto (List<Turma> turmas);


}
