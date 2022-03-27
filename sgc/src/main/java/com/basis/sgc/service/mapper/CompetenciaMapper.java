package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.Categoria;
import com.basis.sgc.domain.Competencia;
import com.basis.sgc.service.dto.CategoriaDTO;
import com.basis.sgc.service.dto.CompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenciaMapper extends EntityMapper<CompetenciaDTO, Competencia> {

    @Mapping(target = "categoria.id", source = "id_categoria")
    Competencia toEntity(CompetenciaDTO competenciaDTO);

    @Mapping(target = "id_categoria", source = "categoria.id")
    CompetenciaDTO toDto (Competencia competencia);

    @Mapping(target = "categoria.id", source = "id_categoria")
    List<Competencia> toEntity (List<CompetenciaDTO> competenciaDTOS);

    @Mapping(target = "id_categoria", source = "categoria.id")
    List<CompetenciaDTO> toDto (List<Competencia> competencias);


}
