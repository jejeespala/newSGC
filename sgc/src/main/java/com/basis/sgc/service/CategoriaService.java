package com.basis.sgc.service;

import com.basis.sgc.repository.CategoriaRepository;
import com.basis.sgc.service.dto.CategoriaDTO;
import com.basis.sgc.service.mapper.CategoriaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaMapper categoriaMapper;

    private final CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> buscar(){

        return categoriaMapper.toDto(categoriaRepository.findAll());
    }
}
