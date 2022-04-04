package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.Turma;
import com.basis.sgc.service.dto.TurmaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurmaMapper extends EntityMapper<TurmaDTO, Turma> {

    @Mapping(target = "status.id", source = "id_status")
    Turma toEntity(TurmaDTO turmaDTO);


    @Mapping(target = "id_status", source = "status.id")
    TurmaDTO toDto (Turma turma);

    @Mapping(target = "status.id", source = "id_status")
    List<Turma> toEntity (List<TurmaDTO> turmaDTOS);

    @Mapping(target = "id_status", source = "status.id")
    List<TurmaDTO> toDto (List<Turma> turmas);


}
