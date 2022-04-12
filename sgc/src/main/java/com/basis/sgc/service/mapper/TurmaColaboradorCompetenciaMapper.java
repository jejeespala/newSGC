package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.TurmaColaboradorCompetencia;
import com.basis.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurmaColaboradorCompetenciaMapper extends EntityMapper<TurmaColaboradorCompetenciaDTO, TurmaColaboradorCompetencia> {

    @Mapping(target = "id.id_colaborador", source = "id_colaborador")
    @Mapping(target = "id.id_competencia", source = "id_competencia")
    @Mapping(target = "id.id_turma", source = "id_turma")
    @Mapping(target = "turma.id", source = "id_turma")
    @Mapping(target = "colaborador.id", source = "id_colaborador")
    @Mapping(target = "competencia.id", source = "id_competencia")
    TurmaColaboradorCompetencia toEntity(TurmaColaboradorCompetenciaDTO turmaColaboradorCompetenciaDTO);

    @Mapping(target = "id_turma", source = "id.id_turma")
    @Mapping(target = "id_colaborador", source = "id.id_colaborador")
    @Mapping(target = "id_competencia", source = "id.id_competencia")
    TurmaColaboradorCompetenciaDTO toDto (TurmaColaboradorCompetencia turmaColaboradorCompetencia);



}
