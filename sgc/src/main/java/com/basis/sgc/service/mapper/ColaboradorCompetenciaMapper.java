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

    @Mapping(target = "id.idCompetencia", source = "idCompetencia")
    @Mapping(target = "id.idColaborador", source = "idColaborador")
    @Mapping(target = "colaborador.id", source = "idColaborador")
    @Mapping(target = "competencia.id", source = "idCompetencia")
    ColaboradorCompetencia toEntity(ColaboradorCompetenciaDTO colaboradorCompetenciaDTO);

    @Mapping(target = "idColaborador", source = "colaborador.id")
    @Mapping(target = "idCompetencia", source = "competencia.id")
    ColaboradorCompetenciaDTO toDto (ColaboradorCompetencia colaboradorCompetencia);



}
