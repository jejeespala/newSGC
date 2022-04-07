package com.basis.sgc.service;

import com.basis.sgc.repository.CategoriaRepository;
import com.basis.sgc.service.dto.CategoriaDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> buscar(){

        return categoriaRepository.listar();

    }
}
