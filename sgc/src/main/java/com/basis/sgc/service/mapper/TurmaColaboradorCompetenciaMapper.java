package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.TurmaColaboradorCompetencia;
import com.basis.sgc.service.dto.TurmaColaboradorCompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TurmaColaboradorCompetenciaMapper extends EntityMapper<TurmaColaboradorCompetenciaDTO, TurmaColaboradorCompetencia> {

    @Mapping(target = "id.idColaborador", source = "idColaborador")
    @Mapping(target = "id.idCompetencia", source = "idCompetencia")
    @Mapping(target = "id.idTurma", source = "idTurma")
    @Mapping(target = "turma.id", source = "idTurma")
    @Mapping(target = "colaborador.id", source = "idColaborador")
    @Mapping(target = "competencia.id", source = "idCompetencia")
    TurmaColaboradorCompetencia toEntity(TurmaColaboradorCompetenciaDTO turmaColaboradorCompetenciaDTO);

    @Mapping(target = "idTurma", source = "id.idTurma")
    @Mapping(target = "idColaborador", source = "id.idColaborador")
    @Mapping(target = "idCompetencia", source = "id.idCompetencia")
    TurmaColaboradorCompetenciaDTO toDto (TurmaColaboradorCompetencia turmaColaboradorCompetencia);



}
