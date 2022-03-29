package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.Colaborador;
import com.basis.sgc.domain.Competencia;
import com.basis.sgc.service.dto.ColaboradorDTO;
import com.basis.sgc.service.dto.CompetenciaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColaboradorMapper extends EntityMapper<ColaboradorDTO, Colaborador> {

    @Mapping(target = "senioridade.id", source = "id_senioridade")
    Colaborador toEntity(ColaboradorDTO colaboradorDTO);

    @Mapping(target = "id_senioridade", source = "senioridade.id")
    ColaboradorDTO toDto (Colaborador colaborador);

    @Mapping(target = "senioridade.id", source = "id_senioridade")
    List<Colaborador> toEntity (List<ColaboradorDTO> colaboradorDTOS);

    @Mapping(target = "id_senioridade", source = "senioridade.id")
    List<ColaboradorDTO> toDto (List<Colaborador> colaboradors);


}
