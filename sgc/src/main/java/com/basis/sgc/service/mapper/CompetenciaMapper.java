package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.Competencia;
import com.basis.sgc.service.dto.CompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper extends EntityMapper<CompetenciaDTO, Competencia> {

    @Mapping(target = "categoria.id", source = "idCategoria")
    Competencia toEntity(CompetenciaDTO competenciaDTO);

    @Mapping(target = "idCategoria", source = "categoria.id")
    CompetenciaDTO toDto (Competencia competencia);

    @Mapping(target = "categoria.id", source = "idCategoria")
    List<Competencia> toEntity (List<CompetenciaDTO> competenciaDTOS);

    @Mapping(target = "idCategoria", source = "categoria.id")
    List<CompetenciaDTO> toDto (List<Competencia> competencias);


}
