package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.ColaboradorCompetencia;
import com.basis.sgc.service.dto.ColaboradorCompetenciaDTO;
import com.basis.sgc.service.dto.ColaboradorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColaboradorCompetenciaMapper extends EntityMapper<ColaboradorCompetenciaDTO, ColaboradorCompetencia> {

    @Mapping(target = "id.id_competencia", source = "id_competencia")
    @Mapping(target = "id.id_colaborador", source = "id_colaborador")
    @Mapping(target = "colaborador.id", source = "id_colaborador")
    @Mapping(target = "competencia.id", source = "id_competencia")
    ColaboradorCompetencia toEntity(ColaboradorCompetenciaDTO colaboradorCompetenciaDTO);

    @Mapping(target = "id_colaborador", source = "colaborador.id")
    @Mapping(target = "id_competencia", source = "competencia.id")
    ColaboradorCompetenciaDTO toDto (ColaboradorCompetencia colaboradorCompetencia);


    @Mapping(target = "id.id_competencia", source = "id_competencia")
    @Mapping(target = "id.id_colaborador", source = "id_colaborador")
    @Mapping(target = "colaborador.id", source = "id_colaborador")
    @Mapping(target = "competencia.id", source = "id_competencia")
    List<ColaboradorCompetencia> toEntity (List<ColaboradorCompetenciaDTO> colaboradorCompetenciaDTOS);


    @Mapping(target = "id_colaborador", source = "colaborador.id")
    @Mapping(target = "id_competencia", source = "competencia.id")
    List<ColaboradorCompetenciaDTO> toDto (List<ColaboradorCompetencia> colaboradorCompetencias);


}
