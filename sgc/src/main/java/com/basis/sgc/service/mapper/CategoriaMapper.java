package com.basis.sgc.service.mapper;

import com.basis.sgc.domain.Categoria;
import com.basis.sgc.service.dto.CategoriaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper extends EntityMapper<CategoriaDTO, Categoria> {

}